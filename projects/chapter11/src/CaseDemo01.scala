import scala.io.StdIn

object CaseDemo01 {

  //  1. 提示用户录入一个数字(1~5), 然后根据用户录入的数字, 打印出他/她上辈子的职业.
  //  2. 假设: 1-> 一品带刀侍卫, 2 -> 宰相, 3 -> 江湖郎中, 4 -> 打铁匠, 5 -> 店小二.

  def main(args: Array[String]): Unit = {

    var number : Int = StdIn.readInt()

    number match {
      case 1 => println("一品带刀侍卫")
      case 2 => println("宰相")
      case 3 => println("江湖郎中")
      case 4 => println("打铁匠")
      case 5 => println("店小二")
      case _ => println("输入错误")
    }
  }
}
