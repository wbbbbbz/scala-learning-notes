import java.io.{BufferedWriter, FileWriter}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object CaseDemo01 {

  //  按照学员的总成绩降序排列后,
  //  按照姓名语文成绩数学成绩英语成绩总成绩的格式,
  //  将数据写到项目下的data文件夹的stu.txt文件中.
  //  1. 定义样例类Person, 属性为: 姓名, 语文成绩, 数学成绩, 英语成绩, 且该类中有一个获取总成绩的方法.
  //  2. 读取指定文件(./data/student.txt)中所有的数据, 并将其封装到List列表中.
  //  3. 定义可变的列表ListBuffer[Student], 用来记录所有学生的信息.
  //  4. 遍历第二步获取到的数据, 将其封装成Person类的对象后, 并添加到ListBuffer中.
  //  5. 对第4步获取到的数据进行排序操作, 并将其转换成List列表.
  //  6. 按照指定格式, 通过BufferWriter将排序后的数据写入到目的地文件中(./data/stu.txt)
  //  7. 关闭流对象

  case class Student(name: String, chnScore: Int, matScore: Int, engScore: Int) {

    def getTotalScore = this.chnScore + this.matScore + this.engScore

  }

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("./data/student.txt")

    val list1 = source.getLines().toList.map(_.split("\\s"))

    source.close()

    val bufferList = new ListBuffer[Student]

    bufferList.addAll(list1.map(i => Student(i(0), i(1).toInt, i(2).toInt, i(3).toInt)))

    bufferList.sortWith((s1, s2) => s1.getTotalScore > s2.getTotalScore)

    val bw = new BufferedWriter(new FileWriter("./data/stu.txt"))

    for (i <- bufferList){
      bw.write(s"${i.name} ${i.chnScore} ${i.matScore} ${i.engScore} ${i.getTotalScore}\r\n")
    }

    bw.close()

  }
}
