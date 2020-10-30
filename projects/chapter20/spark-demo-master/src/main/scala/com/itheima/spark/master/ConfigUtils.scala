package com.itheima.spark.master

import com.typesafe.config.{Config, ConfigFactory}

//针对于Master配置文件的工具类, 用来读取配置文件信息的.
object ConfigUtils {
  //1. 获取配置文件对象.
  private val config: Config = ConfigFactory.load()
  //2. 获取检查Worker心跳的时间间隔.
  val `master.check.heartbeat.interval` = config.getInt("master.check.heartbeat.interval")
  //3. 获取Worker心跳超时时间.
  val `master.check.heartbeat.timeout` = config.getInt("master.check.heartbeat.timeout")
}
