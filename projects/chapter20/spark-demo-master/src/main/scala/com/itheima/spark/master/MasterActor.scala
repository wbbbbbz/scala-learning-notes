package com.itheima.spark.master

import java.util.Date

import akka.actor.Actor
import com.itheima.spark.common.{RegisterSuccessMessage, WorkerHeartBeatMessage, WorkerInfo, WorkerRegisterMessage}

//自定义的MasterActor对象,用来管理多个: WorkerActor对象的.
//负责管理MasterActor的ActorSystem的路径是: akka.tcp://actorSystem@127.0.0.1:7000
object MasterActor extends Actor {
  //1. 定义一个可变的Map集合, 用来保存注册好的Worker信息.
  private val regWorkerMap = scala.collection.mutable.Map[String, WorkerInfo]()

  //定时检查Worker的心跳消息的.
  override def preStart(): Unit = {
    //1. 导入时间隐式参数和隐式转换.
    import context.dispatcher
    import scala.concurrent.duration._
    //2. 启动定时任务.
    context.system.scheduler.schedule(0 seconds, ConfigUtils.`master.check.heartbeat.interval` seconds) {
      //3. 过滤大于超时时间的worker.
      val timeOutWorkerMap = regWorkerMap.filter {
        keyVal => //keyVal的数据格式: WorkerActor对象的id -> 具体的WorkerActor对象(id, cpu, mem, time)
          //3.1 获取当前WorkerActor对象的最后一次心跳时间.
          val lastHeartBeatTime = keyVal._2.lastHeartBeatTime
          //3.2 根据超时公式, 计算它是否超时, 如果超时, 返回true.
          //超时公式: (当前时间 - 最后一次心跳时间) > 最大超时时间 * 1000
          if (new Date().getTime - lastHeartBeatTime > ConfigUtils.`master.check.heartbeat.timeout` * 1000) true else false
      }

      //4. 移除超时的worker.
      if (!timeOutWorkerMap.isEmpty) {
        regWorkerMap --= timeOutWorkerMap.map(_._1)
      }

      //5. 对worker(还活着的)按照内存大小进行降序排列, 然后打印.
      //5.1 获取所有还存活的Worker对象, List列表.
      val workerList = regWorkerMap.map(_._2).toList
      //5.2 按照内存进行降序排列.
      val sortedWorkerList = workerList.sortBy(_.mem).reverse
      //5.3 打印结果.
      println("按照内存的大小降序排列的Worker对象, 信息如下: ")
      println(sortedWorkerList)
    }

  }

  override def receive: Receive = {
    //2. 接收Worker的注册信息.
    case WorkerRegisterMessage(workerId, cpu, mem) => {
      //3. 打印接收到的注册信息.
      println(s"MasterActor接收到Worker的注册信息: ${workerId}, ${cpu}, ${mem}")

      //4. 把注册成功后的数据, 保存到: 双列集合中.
      regWorkerMap += workerId -> WorkerInfo(workerId, cpu, mem, new Date().getTime)

      //5. 给WorkerActor(注册者)一个 回执信息.
      sender ! RegisterSuccessMessage
    }

    //接收WorkerActor发送过来的心跳消息
    case WorkerHeartBeatMessage(workerId, cpu, mem) => {
      //1. 打印接收到的心跳信息.
      println(s"MasterActor: 接收到 ${workerId} 的心跳消息")
      //2. 更新指定的Worker对象的最后一次心跳时间.
      regWorkerMap += workerId -> WorkerInfo(workerId, cpu, mem, new Date().getTime)

      //3. 为了更好的测试我们的代码是否OK, 所以我们可以打印一下: regWorkerMap
      //println(regWorkerMap)
    }
  }
}
