object ClassDemo03 {

  //  伴生类
  class Generals {
    def toWar() : Unit = {
      println(s"武将拿着${Generals.weapon}武器, 上阵杀敌!")
    }
  }

  //  伴生类
  object Generals {
    private var weapon : String = "倚天剑"

    def getWeapon() : String = weapon

    def setWeapon(weapon : String) : Unit = {
      this.weapon = weapon
    }
  }

  def main(args: Array[String]): Unit = {
    new Generals().toWar()
  }

}
