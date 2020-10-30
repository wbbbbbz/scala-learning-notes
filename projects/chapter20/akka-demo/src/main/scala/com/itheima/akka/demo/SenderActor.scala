package com.itheima.akka.demo

import akka.actor.Actor

object SenderActor extends Actor {
    /*
  细节:
  在Actor并发编程模型中, 需要实现act方法, 想要持续接收消息, 可通过loop + react实现.
  在Akka编程模型中, 需要实现receive方法, 直接在receive方法中编写偏函数处理消息即可.
  */
  //重写receive()方法
  override def receive: Receive = {
    //1. 接收Entrance发送过来的: start
    case "start" => {
      //2. 打印接收到的数据.
      println("SenderActor接收到: Entrance发送过来的 start 信息.")

      //3. 获取ReceiverActor的具体路径.
      //参数: 要获取的Actor的具体路径.
      //格式: akka://actorSystem的名字/user/要获取的Actor的名字.
      val receiverActor = context.actorSelection("akka://actorSystem/user/receiverActor")

      //4. 给ReceiverActor发送消息: 采用样例类SubmitTaskMessage
      receiverActor ! SubmitTaskMessage("我是SenderActor, 我在给你发消息!...")
    }

    //5. 接收ReceiverActor发送过来的回执信息.
    case SuccessSubmitTaskMessage(msg) => println(s"SenderActor接收到回执信息: ${msg} ")
  }
}
