object ClassDemo01 {
  def main(args: Array[String]): Unit = {
    //1. 创建空的, 用来存储Int类型数据的Traversable对象.
    //1.1 创建对象.
    val t1: Traversable[Int] = Traversable.empty[Int]
    val t2: Traversable[Int] = Traversable[Int]()
    val t3: Traversable[Int] = Nil
    //1.2 比较它们是否相等.
    println(t1 == t2)   //==比较的是集合中的数据.
    println(t1 == t3)
    println(t2 == t3)

    println(t1 eq t2)   //eq比较的是集合的地址值.
    println(t1 eq t3)
    println(t2 eq t3)
    println("-" * 15)

    //2. 创建Traversable集合对象, 存储数字1, 2, 3, 并将结果打印到控制台上.
    //2.1 通过toTraversable()方法实现.
    val t4: Traversable[Int] = List(1, 2, 3).toTraversable
    val t5: Traversable[Int] = Set(1, 2, 3).toTraversable

    //2. 通过Traversable的伴生对象的apply()方法实现.
    val t6:Traversable[Int] = Traversable(11, 22, 33, 44, 55)

    //3. 打印结果(因为Traversable是特质, 所以底层还是通过它的具体子类来实现的).
    println(s"t4: ${t4}")
    println(s"t5: ${t5}")
    println(s"t6: ${t6}")
  }
}