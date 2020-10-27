object CaseDemo01 {

  //  1. 定义一个RichList类, 用来给普通的List添加avg()方法，用于获取列表元素的平均值.
  //  2. 定义avg()方法, 用来获取List列表中所有元素的平均值.
  //  3. 定义隐式转换方法, 用来将普通List对象转换为RichList对象.
  //  4. 定义List列表, 获取其中所有元素的平均值

  class RichList(list: List[Int]) {
    def avg() = list.reduce(_ + _) / list.size
  }

  def main(args: Array[String]): Unit = {
    implicit def list2RichList(list : List[Int]) : RichList = new RichList(list)
    println((1 to 100).toList.avg())
  }
}
