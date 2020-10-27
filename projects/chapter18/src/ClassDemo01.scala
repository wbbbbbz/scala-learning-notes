object ClassDemo01 {
  def main(args: Array[String]): Unit = {
    //1. 定义Iterable集合, 存储1~13之间的数字.
    val i1 = (1 to 13).toIterable
    //2. 通过grouped方法按照5个元素为一组的方式, 对Iterable集合分组.
    val result1 = i1.grouped(5)
    //3. 遍历元素, 打印结果.
    while (result1.hasNext) {
      println(result1.next())
    }
  }
}
