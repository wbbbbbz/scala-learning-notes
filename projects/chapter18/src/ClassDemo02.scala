import scala.collection.mutable

object ClassDemo02 {
  def main(args: Array[String]): Unit = {
    //1. 定义Iterable集合i1, 包含"A", "B", "C"这三个元素.
    val i1 = Iterable("A", "B", "C")
    //2. 判断i1和Iterable("A", "B", "C")集合是否相同.
    println(i1.sameElements(Iterable("A", "B", "C")))
    //3. 判断i1和Iterable("A", "C", "B")集合是否相同.
    println(i1.sameElements(Iterable("A", "C", "B")))
    //4. 定义Iterable集合i2, 包含"A", "B", "C", "D"这四个元素.
    val i2 = Iterable("A", "B", "C", "D")
    //5. 判断i1和i2是否相同.
    println(i1.sameElements(i2))

    //6. 扩展: 创建HashSet集合存储1, 2, 创建TreeSet集合存储2, 1, 然后判断它们是否相同.
    val hs = mutable.HashSet(1, 2)
    val ts = mutable.TreeSet(2, 1)
    println(hs.sameElements(ts)) //结果是true, 因为TreeSet会对元素排序.
  }
}
