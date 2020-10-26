object ClassDemo05 {

  class Person

  class Student extends Person

  def main(args: Array[String]): Unit = {

    //3. 创建Student类型的对象, 指定其类型为Person.
    val p:Person = new Student
    //4. 通过isInstanceOf关键字判断其是否是Person类型的对象.
    println(p.isInstanceOf[Person])       	//true,
    //5. 通过isInstanceOf关键字判断其是否是Person类型的对象.
    println(p.isInstanceOf[Student])     	//true
    //6. 通过getClass, ClassOf判断其是否是Person类型的对象.
    println(p.getClass == classOf[Person])    //false
    //7. 通过getClass, ClassOf判断其是否是Student类型的对象.
    println(p.getClass == classOf[Student])   //true
  }
}
