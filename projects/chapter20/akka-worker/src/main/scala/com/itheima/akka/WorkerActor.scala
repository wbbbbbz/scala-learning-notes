package com.itheima.akka

import akka.actor.Actor

object WorkerActor extends Actor {
  override def receive: Receive = {
    case "setup" => {
      println("WorkerActor接收到: Entrance发送过来的指令 setup!.")

      //2. 获取MasterActor的引用.
      val masterActor = context.system.actorSelection("akka.tcp://actorSystem@127.0.0.1:8888/user/masterActor")

      //3. 给MasterActor发送一句话.
      masterActor ! "connect"
    }

    //4. 接收MasterActor的回执信息.
    case "success" => println("WorkerActor接收到: success!")
  }
}
