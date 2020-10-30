package com.itheima.spark.worker

import java.util.UUID

import akka.actor.{Actor, ActorSelection}
import com.itheima.spark.common.{RegisterSuccessMessage, WorkerHeartBeatMessage, WorkerRegisterMessage}

import scala.util.Random

//自定义的WorkerActor对象,用来处理(执行): MasterActor分配的任务的.
//负责管理WorkerActor的ActorSystem的路径是: akka.tcp://actorSystem@127.0.0.1:8000
object WorkerActor extends Actor{
  //1. 定义一些成员变量, 用来记录MasterActor的应用, 以及WorkerActor的注册参数信息.
  private var masterActorRef: ActorSelection = _      //表示MasterActor的引用.
  private var workerId:String = _                     //表示WorkerActor的Id
  private var cpu:Int = _                             //表示WorkerActor的CPU核数.
  private var mem:Int = _                             //表示WorkerActor的内存大小.
  private val cpu_list = List(1, 2, 3, 4, 6, 8)       //表示CPU核心数的取值范围
  private val mem_list = List(512, 1024, 2048, 4096)  //表示内存大小的取值范围.

  //2. 重写preStart()方法, 里边的内容, 在Actor启动之前就会执行.
  override def preStart(): Unit = {
    //3. 获取MasterActor的引用.
    //格式: akka.tcp://ActorSystem的路径/user/具体的Actor的名字
    masterActorRef = context.system.actorSelection("akka.tcp://actorSystem@127.0.0.1:7000/user/masterActor")

    //4. 构建注册信息.
    workerId = UUID.randomUUID().toString
    //创建随机数对象
    val r = new Random()
    cpu = cpu_list(r.nextInt(cpu_list.length))
    mem = mem_list(r.nextInt(mem_list.length))
    //5. 将WorkerActor的注册信息封装成: WorkerRegisterMessage对象.
    val registerMessage = WorkerRegisterMessage(workerId,cpu, mem)
    //6. 发送消息给MasterActor即可.
    masterActorRef ! registerMessage
  }

  override def receive: Receive = {
    //接收注册成功的回执信息, 然后打印.
    case RegisterSuccessMessage => {
      println("WorkerActor: 注册成功!")

      //定时的给MasterActor发送心跳消息.
      //核心细节: 通过 定时器实现.
      //1. 导入隐式参数和隐式转换.
      import scala.concurrent.duration._
      import context.dispatcher

      //2. 调用schedule()方法即可.
      //                             延期启动时间           间隔时间
      context.system.scheduler.schedule(0 seconds, ConfigUtils.`worker.heartbeat.interval` seconds) (
        //具体的发送心跳消息的阶段
        masterActorRef ! WorkerHeartBeatMessage(workerId, cpu, mem)
      )
    }
  }
}
