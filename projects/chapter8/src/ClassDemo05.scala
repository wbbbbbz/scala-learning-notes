object ClassDemo05 {

  trait Logger {
    def log(msg : String) = println(s"打印${msg}")
  }

  class User

  def main(args: Array[String]): Unit = {
    var user = new User with Logger

    user.log("information")

    println(user.getClass())
  }

}
