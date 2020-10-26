object ClassDemo01 {

  //案例: 演示Scala中的访问修饰符.
  /*
    注意:
      1. Scala中可以使用private/protected来修饰成员.
      2. 如果成员没有被private/protected修饰, 默认就是公共的(类似于Java中的public).
   */
  //1. 创建Customer类
  class Customer(var sex: String) {
    //2. 定义成员变量, 全部私有化
    private var name = "" //姓名
    private var age = 0 //年龄

    //3. 定义成员方法
    //获取姓名
    def getName() = name

    //设置姓名
    def setName(name: String) = this.name = name

    //获取年龄
    def getAge() = age

    //设置年龄
    def setAge(age: Int) = this.age = age

    //2. 定义一个辅助构造器, 接收一个数组参数
    def this(arr:Array[String]) {
      this(arr(0))    //将数组的第一个元素传给主构造器.
    }

    //打招呼的方法, 该方法需要私有化.
    private def sayHello() = println("Hello, Scala!")
  }

  //1. 定义单例对象Dog
  object Dog {
    //2. 定义一个变量, 用来存储狗腿子的数量
    val leg_num = 4
  }

  //1. 定义单例对象PrintUtil
  object PrintUtil {
    //2. 定义一个方法, 用来打印分割线
    def printSpliter() = println("-" * 15)
  }

  //定义main函数, 它是程序的主入口.
  def main(args: Array[String]): Unit = {
    //4. 创建Customer类型的对象.
    val c = new Customer(Array("M", "fawilega"))
    //5. 给成员变量赋值
//    c.name = "张三"     //这样写会报错, 因为私有成员外界无法直接访问.
    c.setName("张三")
    c.setAge(23)
    //6. 打印成员变量值到控制台上
    println(c.getName(), c.getAge(), c.sex)
    //7. 尝试调用私有成员方法
    //c.sayHello()       //这样写会报错, 因为私有成员外界无法直接访问.

    println(Dog.leg_num)
    PrintUtil.printSpliter()
  }
}
