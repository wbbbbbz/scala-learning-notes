package com.itheima.spark.common

/**
  * Worker提交注册信息的样例类
  * @param workerId  WorkerAcotr的id
  * @param cpu 当前WorkerActor的CPU核数
  * @param mem 当前WorkerActor的内存大小, 单位: MB
  */
case class WorkerRegisterMessage(workerId:String, cpu:Int, mem:Int)

//注册成功后的 消息样例对象.
case object RegisterSuccessMessage

//表示心跳信息.
case class WorkerHeartBeatMessage(workerId:String, cpu:Int, mem:Int)
