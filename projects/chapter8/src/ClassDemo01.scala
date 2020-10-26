object ClassDemo01 {

  trait Logger {
    def log(msg : String)
  }

  class ConsoleLogger extends Logger {
    override def log(msg: String): Unit = println(s"使用特质打印${msg}")
  }

  def main(args: Array[String]): Unit = {
    new ConsoleLogger().log("消息消息")
  }
}
