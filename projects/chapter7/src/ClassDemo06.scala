object ClassDemo06 {

  abstract class Shape {
    def area(): Double
  }

  class Square(var edge : Double) extends Shape {
    override def area(): Double = {
      return edge * edge
    }
  }

  class Rectangle(var length : Double, var width : Double) extends Shape {
    override def area(): Double = {
      return length * width
    }
  }

  class Circle(var radius : Double) extends Shape {
    override def area(): Double = {
      return radius * radius * Math.PI
    }
  }

  def main(args: Array[String]): Unit = {
    val s1:Shape = new Square(2)
    val s2:Shape = new Rectangle(2,3)
    val s3:Shape = new Circle(2)

    println(s1.area)
    println(s2.area)
    println(s3.area)
  }
}
