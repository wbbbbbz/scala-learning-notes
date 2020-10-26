object ClassDemo02 {

  trait MessageSender {
    def send(msg : String)
  }

  trait MessageReceiver {
    def receive()
  }

  class MessageWorker extends MessageSender with MessageReceiver {
    override def send(msg: String): Unit = println(s"发送${msg}")

    override def receive(): Unit = println("接收")
  }

  def main(args: Array[String]): Unit = {
    new MessageWorker().send("消息")
    new MessageWorker().receive()
  }
}
