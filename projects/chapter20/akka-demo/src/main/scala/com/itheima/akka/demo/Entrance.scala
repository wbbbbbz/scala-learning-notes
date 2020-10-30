package com.itheima.akka.demo

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Entrance {

  def main(args: Array[String]): Unit = {
    //1. 实现一个Actor Trait, 其实就是创建两个Actor对象(上述步骤已经实现).

    //2. 创建ActorSystem
    //两个参数的意思分别是:ActorSystem的名字, 加载配置文件(此处先不设置)
    val actorSystem = ActorSystem("actorSystem",ConfigFactory.load())

    //3. 加载Actor
    //actorOf方法的两个参数意思是: 1. 具体的Actor对象. 2.该Actor对象的名字
    val senderActor = actorSystem.actorOf(Props(SenderActor), "senderActor")
    val receiverActor = actorSystem.actorOf(Props(ReceiverActor), "receiverActor")

    //3. 由ActorSystem给 SenderActor发送一句话"start".
//    senderActor ! "start"

    //4. 导入隐式转换和隐式参数.
    //导入隐式转换, 用来支持 定时器.
    import actorSystem.dispatcher
    //导入隐式参数, 用来给定时器设置默认参数.
    import scala.concurrent.duration._

    // 通过定时器，定时给ReceiverActor发送消息
//    actorSystem.scheduler.schedule(
//      initialDelay = 3.second
//      , interval = 1.second
//      , receiver = receiverActor
//      , message = "间隔发送消息")
//
//    actorSystem.scheduler.schedule(
//      initialDelay = 3.second
//      , interval = 1.second
//    )(receiverActor ! "间隔传送消息")

//    // 开发写法：
//    actorSystem.scheduler.schedule(
//      initialDelay = 0.second
//      , interval = 2.second
//    ) {
//      receiverActor ! "你好"
//    }
  }

}
