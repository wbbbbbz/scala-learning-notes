//案例: 演示适配器设计模式.
object ClassDemo06 {
  //1. 定义特质PlayLOL, 添加6个抽象方法, 分别为: top(), mid(), adc(), support(), jungle(), schoolchild()
  trait PlayLOL {
    def top()           //上单
    def mid()           //中单
    def adc()           //下路
    def support()       //辅助
    def jungle()        //打野
    def schoolchild()   //小学生
  }

  //2. 定义抽象类Player, 继承PlayLOL特质, 重写特质中所有的抽象方法, 方法体都为空.
  //Player类充当的角色就是: 适配器类.
  class Player extends PlayLOL {
    override def top(): Unit = {}
    override def mid(): Unit = {}
    override def adc(): Unit = {}
    override def support(): Unit = {}
    override def jungle(): Unit = {}
    override def schoolchild(): Unit = {}
  }

  //3. 定义普通类GreenHand, 继承Player, 重写support()和schoolchild()方法.
  class GreenHand extends Player{
    override def support(): Unit = println("我是辅助, B键一扣, 不死不回城!")
    override def schoolchild(): Unit = println("我是小学生, 你骂我, 我就挂机!")
  }

  //4. 定义main方法, 在其中创建GreenHand类的对象, 并调用其方法进行测试.
  def main(args: Array[String]): Unit = {
    //创建GreenHand类的对象
    val gh = new GreenHand
    //调用GreenHand类中的方法
    gh.support()
    gh.schoolchild()
  }
}
