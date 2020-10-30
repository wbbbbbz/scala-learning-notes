package com.itheima.spark.worker

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

//程序的入口, 相当于我们以前写的MainActor, Entrance
object Worker {
  def main(args: Array[String]): Unit = {
    //1. 创建ActorSystem对象, 用来管理所有的 用户自定义Actor.
    val actorSystem = ActorSystem("actorSystem", ConfigFactory.load())
    //2. 通过ActorSystem, 关联MasterActor.
    val workerActor = actorSystem.actorOf(Props(WorkerActor), "workerActor")
    //3. 给workerActor发送一个测试数据.
    //workerActor ! "Hello"
  }
}
