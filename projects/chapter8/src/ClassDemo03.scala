object ClassDemo03 {

  trait Logger {
    def log(msg : String)
  }

  trait Warning {
    def warn(msg : String)
  }

  object ConsoleLogger extends Logger with Warning {
    override def log(msg: String): Unit = println(s"log ${msg}")

    override def warn(msg: String): Unit = println(s"warn ${msg}")
  }

  def main(args: Array[String]): Unit = {
    ConsoleLogger.log("information")
    ConsoleLogger.warn("information")
  }
}
