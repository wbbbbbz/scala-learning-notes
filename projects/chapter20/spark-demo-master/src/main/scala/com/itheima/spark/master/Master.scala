package com.itheima.spark.master

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

//程序的入口, 相当于我们以前写的MainActor, Entrance
object Master {
  def main(args: Array[String]): Unit = {
    //1. 创建ActorSystem对象, 用来管理所有的 用户自定义Actor.
    val actorSystem = ActorSystem("actorSystem", ConfigFactory.load())
    //2. 通过ActorSystem, 关联MasterActor.
    val masterActor = actorSystem.actorOf(Props(MasterActor), "masterActor")
    //3. 给MasterActor发送一个测试数据.
    //masterActor ! "Hello"
  }
}
