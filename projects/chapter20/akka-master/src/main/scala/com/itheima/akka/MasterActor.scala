package com.itheima.akka

import akka.actor.Actor

object MasterActor extends Actor {
  override def receive: Receive = {
    case "connect" => {
      println("MasterActor接收到: connect!...")

      //2. 给WorkerActor回执一句话.
      sender ! "success"
    }
  }
}
