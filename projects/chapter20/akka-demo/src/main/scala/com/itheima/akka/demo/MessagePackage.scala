package com.itheima.akka.demo

/**
 * 记录发送消息的 样例类.
 * @param msg  具体的要发送的信息.
 */
case class SubmitTaskMessage(msg:String)

/**
 * 记录 回执信息的 样例类.
 * @param msg  具体的回执信息.
 */
case class SuccessSubmitTaskMessage(msg:String)
