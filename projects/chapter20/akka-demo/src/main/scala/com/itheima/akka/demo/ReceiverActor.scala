package com.itheima.akka.demo

import akka.actor.Actor

object ReceiverActor extends Actor {
  override def receive: Receive = {
    //1. 接收SenderActor发送过来的消息.
    case SubmitTaskMessage(msg) => {
      //2. 打印接收到的消息.
      println(s"ReceiverActor接收到: ${msg}")

      //3. 给出回执信息.
      sender ! SuccessSubmitTaskMessage("接收任务成功!. 我是ReceiverActor")
    }
    case msg: String => println(msg)
  }
}
