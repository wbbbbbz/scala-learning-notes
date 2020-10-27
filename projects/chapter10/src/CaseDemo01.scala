object CaseDemo01 {

  def main(args: Array[String]): Unit = {
    //  1. 定义列表, 记录学生的成绩, 格式为: 姓名, 语文成绩, 数学成绩, 英语成绩, 学生信息如下: ("张三",37,90,100),("李四",90,73,81), ("王五",60,90,76), ("赵六",59,21,72), ("田七",100,100,100)
    //  2. 获取所有语文成绩在60分(含)及以上的同学信息.
    //  3. 获取所有学生的总成绩.
    //  4. 按照总成绩降序排列.
    //  5. 打印结果.

    //1.定义列表,记录学生的成绩,格式为:姓名,语文成绩,数学成绩,英语成绩
    val stuList = List(("张三", 37, 90, 100), ("李四", 90, 73, 81), ("王五", 60, 90, 76), ("赵六", 59, 21, 72), ("田七", 100, 100, 100))
    //  2. 获取所有语文成绩在60分(含)及以上的同学信息.
    println(stuList.filter(_._2 >= 60))
    //  3. 获取所有学生的总成绩.
    val total = stuList.map(t => t._1 -> (t._2 + t._3 + t._4))
    println(total)
    //  4. 按照总成绩降序排列.
    //  5. 打印结果.
    println(total.sortWith((a, b) => a._2 > b._2))

  }

}