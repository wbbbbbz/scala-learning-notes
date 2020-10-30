package com.itheima.akka

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Entrance {

  def main(args: Array[String]): Unit = {

    val actorSystem = ActorSystem("actorSystem", ConfigFactory.load())

    val workerActor = actorSystem.actorOf(Props(WorkerActor), "workerActor")

    workerActor ! "setup"
  }

}
