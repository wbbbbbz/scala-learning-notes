import java.text.SimpleDateFormat
import java.util.Date
//案例: 定义DateUtils工具类, 用于实现String和Date之间的相互转换.
object ClassCase01 {

  //1. 定义DateUtils工具类.    //也就是Scala中的单例对象.
  object DateUtils {
    //2. 创建SimpleDateFormat类型的对象, 用来进行转换操作.
    var sdf: SimpleDateFormat = null

    //3. 定义方法date2String, 用来将Date日期对象转换成String类型的日期.
    //参数1: 日期对象,   参数2: 模板
    def date2String(date: Date, template: String):String  = {
      sdf = new SimpleDateFormat(template)
      sdf.format(date)
    }

    //4. 定义方法string2Date, 用于将String类型的日期转换成Date日期对象.
    def string2Date(dateString: String, template: String) = {
      sdf = new SimpleDateFormat(template)
      sdf.parse(dateString)
    }
  }

  //定义main方法, 作为程序的主入口.
  def main(args: Array[String]): Unit = {
    //5. 调用DateUtils#date2String()方法, 用来格式化日期.
    val s = DateUtils.date2String(new Date(), "yyyy-MM-dd")
    println("格式化日期: " + s)

    //6. 调用DateUtils#string2Date()方法, 用来解析日期字符串.
    val d = DateUtils.string2Date("1314年5月21日", "yyyy年MM月dd日")
    println("解析字符串: " + d)
  }
}
