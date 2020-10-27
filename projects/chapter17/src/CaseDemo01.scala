import scala.util.Random

object CaseDemo01 {

  case class Student (name : String, age : Int){
  }

  def main(args: Array[String]): Unit = {
    val name = List("张三", "李四", "王五", "赵六", "田七")

    val list : Iterable[Student] = Iterable.fill(5)(new Student(name(Random.nextInt(5)), 20 + Random.nextInt(10)))
    println(list.toList.sortWith((s1, s2) => s1.age > s2.age))
  }

}
