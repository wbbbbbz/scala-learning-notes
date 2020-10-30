package com.itheima.spark.worker

import com.typesafe.config.{Config, ConfigFactory}

//自定义的工具类, 用来读取配置文件信息的(WorkerActor定时发送心跳消息的间隔时间.)
object ConfigUtils {
  //1. 获取配置信息对象.
  private val config: Config = ConfigFactory.load()
  //2. 获取worker的心跳间隔时间.
 val `worker.heartbeat.interval`: Int = config.getInt("worker.heartbeat.interval")
}
