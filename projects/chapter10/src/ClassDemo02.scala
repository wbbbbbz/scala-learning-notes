object ClassDemo02 {

  def main(args: Array[String]): Unit = {

    ////    foreach: 用于遍历
    //    val list1 = List(1, 2, 3, 4, 5, 6, 7, 6, 4)
    //    list1.foreach((x:Int) => print(s"${x}\t"))
    //    println()
    //    list1.foreach(x => print(s"${x}\t"))
    //    println()
    //    list1.foreach(println(_))

    //    map: 对集合进行转换
    //    println(list1.map(x => ("*" * x)))

    // flatMap：扁平化映射。先map再flatten
    //    val list2=List("hadoop hive spark flink flume","kudu hbase sqoop storm")
    //    println(list2.flatMap(_.split(" ")))

    // filter: 过滤
    //    println((1 to 9).toList.filter(_ % 2 == 0))

    // 排序: sorted, sortBy, sortWith
    //    val list1 = List(1, 2, 3, 4, 5, 6, 7, 6, 4)
    //    println(list1.sorted)
    //    println(list1.sorted.reverse)

    //    val list1=List("01 hadoop","02 flume","03 hive","04 spark")
    //    println(list1.sortBy(_.split(" ")(1)))

    //    val list1 = List(2,3,1,6,4,5)
    //    // 保证前大后小，也就是降序。
    //    println(list1.sortWith((i1, i2) => (i1 - i2)>0))
    //    println(list1.sortWith(_ > _))

    //    // groupBy: 分组
    //    val list1=List("刘德华"->"男","刘亦菲"->"女","胡歌"->"男")
    //    println(list1.groupBy(_._2))
    ////    println(list1.groupBy(_._2).foreach(map => println(map._2(0)._2, map._2.length)))
    //    println(list1.groupBy(_._2).map(x => x._1 -> x._2.size))

    // reduce: 聚合
    // reduce和reduceLeft一样，从左到右。
    // reduceRight是从右到左
    //    val list1 = (1 to 10).toList
    //    println(list1.reduce(_ + _))

//    // fold: 折叠
//    val list1 = (1 to 10).toList
//    println(list1.fold(100)(_ + _))
  }


}
