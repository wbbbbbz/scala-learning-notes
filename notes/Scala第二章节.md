# Scala第二章节

### 章节目标

1. 掌握变量, 字符串的定义和使用
2. 掌握数据类型的划分和数据类型转换的内容
3. 掌握键盘录入功能
4. 理解Scala中的常量, 标识符相关内容

------

### 1. 输出语句和分号

#### 1.1 输出语句

**方式一:  换行输出**

```scala
格式:  println(里边写你要打印到控制台的数据);
```

**方式二: 不换行输出**

```scala
格式: print(里边写你要打印到控制台的数据);
```

> 注意: `不管是println(), 还是print()语句, 都可以同时打印多个值.格式为: println(值1, 值2, 值3...)`
> println(1, 2, 3, "Hello, World!")
> `与JAVA不一样！`

#### 1.2 分号

Scala语句中,  单行代码最后的分号可写可不写.  如果是多行代码写在一行, 则中间的分号不能省略, 最后一条代码的分号可省略不写. 

示例:

```scala
println("Hello, Scala!")			//最后的分号可写可不写
//如果多行代码写在一行, 则前边语句的分号必须写, 最后一条语句的分号可以省略不写.
println("Hello"); println("Scala")	
```


### 2. Scala中的常量

#### 2.1 概述

常量指的是:  在程序的运行过程中, 其值不能发生改变的量.

#### 2.2 分类

* 字面值常量(常用的有以下几种)
  * 整型常量
  * 浮点型常量
  * 字符常量
  * 字符串常量
  * 布尔常量
  * 空常量
* 自定义常量(稍后解释)

#### 2.3 代码演示

```Scala
//整型常量
println(10)
//浮点型常量
println(10.3)
//字符常量, 值要用单引号括起来
println('a')
//字符串常量, 值要用双引号括起来
println("abc")
//布尔常量, 值只有true和false
println(true)
//空常量
println(null)
```


### 3. Scala中的变量

#### 3.1 概述

我们将来每一天编写scala程序都会定义变量, 那什么是变量, 它又是如何定义的呢?

变量, 指的就是在程序的执行过程中,  其值可以发生改变的量. 定义格式如下: 

#### 3.2 语法格式

Java变量定义

```java
int a = 0;
```

在scala中，可以使用`val`或者`var`来定义变量，语法格式如下:

```scala
val/var 变量名:变量类型 = 初始值
```

其中

- `val`定义的是不可重新赋值的变量, 也就是自定义常量.
- `var`定义的是可重新赋值的变量

> `注意: scala中定义变量时, 类型写在变量名后面`

#### 3.3 示例

**需求**：定义一个变量保存一个人的名字"tom"

**步骤**

1. 打开scala解释器
2. 定义一个字符串类型的变量用来保存名字

**参考代码**

```scala
scala> val name:String = "tom"
name: String = tom
```

#### 3.4 val和var变量的区别

**示例**

给名字变量进行重新赋值为Jim，观察其运行结果

**参考代码**

```scala
scala> name = "Jim"
<console>:12: error: reassignment to val
       name = "Jim"
```

**示例**

使用`var`重新定义变量来保存名字"tom"，并尝试重新赋值为Jim，观察其运行结果

**参考代码**

```scala
scala> var name:String = "tom"
name: String = tom

scala> name = "Jim"
name: String = Jim
```

> 注意:  默认优先使用`val`定义变量，如果变量需要被重新赋值，才使用`var`
>

#### 3.5 使用类型推断来定义变量

scala的语法要比Java简洁，我们可以使用一种更简洁的方式来定义变量。

**示例**

使用更简洁的语法定义一个变量保存一个人的名字"tom"
也就是变量后的类型不写，让scala进行判断。

**参考代码**

```scala
scala> val name = "tom"
name: String = tom
scala> val name = 10
val name: Int = 10   // Int的I是大写！
```

scala可以自动根据变量的值来自动推断变量的类型，这样编写代码更加简洁。



### 4. 字符串

scala提供多种定义字符串的方式，将来我们可以根据需要来选择最方便的定义方式。

- 使用双引号
- 使用插值表达式
- 使用三引号

#### 4.1 使用双引号

语法

```scala
val/var 变量名 = “字符串”
```

**示例**

有一个人的名字叫"hadoop"，请打印他的名字以及名字的长度。

**参考代码**

```scala
scala> val name = "hadoop"
val name: String = hadoop
scala> println(name + name.length)
hadoop6
```

#### 4.2 使用插值表达式

scala中，可以使用插值表达式来定义字符串，有效避免大量字符串的拼接。

语法

```scala
val/var 变量名 = s"${变量/表达式}字符串"
```

> 注意: 
>
> - 在定义字符串之前添加`s`
> - 在字符串中，可以使用`${}`来引用变量或者编写表达式

**示例**

请定义若干个变量，分别保存："zhangsan"、23、"male"，定义一个字符串，保存这些信息。

打印输出：name=zhangsan, age=23, sex=male

**参考代码**

```scala
scala> val name = "zhangsan"
name: String = zhangsan

scala> val age = 23
age: Int = 23

scala> val sex = "male"
sex: String = male

scala> val result = s"name=${name}, age=${age}, sex=${sex}"
result: String = name=zhangsan, age=23, sex=male

scala> println(result)
name=zhangsan, age=23, sex=male
```

#### 4.3 使用三引号

如果有大段的文本需要保存，就可以使用三引号来定义字符串。例如：保存一大段的SQL语句。三个引号中间的所有内容都将作为字符串的值。

语法

```scala
val/var 变量名 = """字符串1
字符串2"""
```

**示例**

定义一个字符串，保存以下SQL语句

```sql
select
	*
from
    t_user
where
    name = "zhangsan"
```

打印该SQL语句

**参考代码**

```scala
val sql = """select
     | *
     | from
     |     t_user
     | where
     |     name = "zhangsan""""

println(sql)
```

#### 4.4 扩展: 惰性赋值

在企业的大数据开发中，有时候会编写非常复杂的SQL语句，这些SQL语句可能有几百行甚至上千行。这些SQL语句，如果直接加载到JVM中，会有很大的内存开销, 如何解决这个问题呢？

当有一些变量保存的数据较大时，而这些数据又不需要**马上**加载到JVM内存中。就可以使用**惰性赋值**来提高效率。

JAVA中的惰性赋值参考：
[java惰性初始化的小例子_iCoding91-CSDN博客](https://blog.csdn.net/caoxiaohong1005/article/details/53122308)
就是一开始不创建对象，直到调用之前再创建

**语法格式：**

```scala
lazy val/var 变量名 = 表达式
```

**示例**

在程序中需要执行一条以下复杂的SQL语句，我们希望只有用到这个SQL语句才加载它。

```scala
"""insert overwrite table adm.itcast_adm_personas
    select
    a.user_id,
    a.user_name,
    a.user_sex,
    a.user_birthday,
    a.user_age,
    a.constellation,
    a.province,
    a.city,
    a.city_level,
    a.hex_mail,
    a.op_mail,
    a.hex_phone,
    a.fore_phone,
    a.figure_model,
    a.stature_model,
    b.first_order_time,
    b.last_order_time,
      ...
    d.month1_hour025_cnt,
    d.month1_hour627_cnt,
    d.month1_hour829_cnt,
    d.month1_hour10212_cnt,
    d.month1_hour13214_cnt,
    d.month1_hour15217_cnt,
    d.month1_hour18219_cnt,
    d.month1_hour20221_cnt,
    d.month1_hour22223_cnt
    from gdm.itcast_gdm_user_basic a
      left join gdm.itcast_gdm_user_consume_order b on a.user_id=b.user_id
    left join gdm.itcast_gdm_user_buy_category c on a.user_id=c.user_id
    left join gdm.itcast_gdm_user_visit d on a.user_id=d.user_id;"""
```

**参考代码**

```scala
scala> lazy val sql = """insert overwrite table adm.itcast_adm_personas
     |     select
     |     a.user_id,
	....
     |     left join gdm.itcast_gdm_user_buy_category c on a.user_id=c.user_id
     |     left join gdm.itcast_gdm_user_visit d on a.user_id=d.user_id;"""
sql: String = <lazy>
```


### 5. 标识符

#### 5.1 概述

​	实际开发中, 我们会编写大量的代码, 这些代码中肯定会有变量, 方法, 类等. 那它们该如何命名呢? 这就需要用到标识符了. **标识符就是用来给变量, 方法, 类等起名字的.** Scala中的标识符和Java中的标识符非常相似.

#### 5.2 命名规则

* 必须由`大小写英文字母, 数字, 下划线_, 美元符$`, 这四部分任意组合组成.
* 数字不能开头.
* 不能和Scala中的关键字重名.
* 最好做到**见名知意.**

#### 5.3 命名规范

* 变量或方法: 从第二个单词开始, 每个单词的首字母都大写, 其他字母全部小写(小驼峰命名法).

  ```Scala
  zhangSanAge, student_Country, getSum
  ```

* 类或特质(Trait): 每个单词的首字母都大写, 其他所有字母全部小写(大驼峰命名法)

  ```scala
  Person, StudentDemo, OrderItems
  ```

* 包: 全部小写, 一般是公司的域名反写, 多级包之间用.隔开.

  ```scala
  com.itheima.add,  cn.itcast.update
  ```




### 6. 数据类型

#### 6.1 简述

强类型：对数据类型划分精细
弱类型：不划分精细，比如PHP, JS
数据类型是用来约束变量(常量)的取值范围的. Scala也是一门强类型语言, 它里边的数据类型绝大多数和Java一样.我们主要来学习

- 与Java不一样的一些用法
- scala中数据类型的继承体系

#### 6.2 数据类型

| 基础类型 | 类型说明                 |
| -------- | ------------------------ |
| Byte     | 8位带符号整数，一个字节            |
| Short    | 16位带符号整数           |
| **Int**  | 32位带符号整数           |
| Long     | 64位带符号整数           |
| Char     | 16位无符号Unicode字符    |
| String   | Char类型的序列（字符串） |
| Float    | 32位单精度浮点数         |
| Double   | 64位双精度浮点数         |
| Boolean  | true或false              |

**注意下 scala类型与Java的区别**

> [!NOTE]
>
> 1. scala中所有的类型都使用**大写字母**开头
> 2. 整形使用`Int`而不是Integer
> 3. scala中定义变量可以不写类型，让scala编译器自动推断
> 4. Scala中默认的整型是Int, 默认的浮点型是: Double。与JAVA一致

#### 6.3 Scala类型层次结构

![1556592270468](../pics/2-1.png)

| 类型    | 说明                                                         |
| ------- | ------------------------------------------------------------ |
| Any     | **所有类型**的父类，它有两个子类AnyRef与AnyVal。相当于JAVA中的Object               |
| AnyVal  | **所有数值类型**的父类                                       |
| AnyRef  | **所有对象类型(引用类型)**的父类                           |
| Unit    | 表示空，Unit是AnyVal的子类，它只有一个的实例{% em %}() {% endem %} 它类似于Java中的void，但scala要比Java更加面向对象。当方法没有明确的返回值时就会使用Unit作为返回值类型。 |
| Null    | Null是AnyRef的子类，也就是说它是所有引用类型的子类。值只有null。它的实例是{% em %}**null**{% endem %} 可以将null赋值给任何对象类型 |
| Nothing | 所有类型的**子类**,  不能直接创建该类型实例，某个方法抛出异常时，返回的就是Nothing类型，因为Nothing是所有类的子类，那么它可以赋值为任何类型。一般结合异常进行使用 |

#### 6.4 思考题

以下代码是否有问题？

```scala
val b:Int = null
            ^
       error: an expression of type Null is ineligible for implicit conversion
```

**Scala会解释报错：** Null类型时所有引用类的子类，与数值类无关。Null类型并不能转换为Int类型，说明**Null类型并不是Int类型的子类**



### 7. 类型转换

#### 7.1 概述

当Scala程序在进行运算或者赋值动作时,  范围小的数据类型值会自动转换为范围大的数据类型值, 然后再进行计算.例如: 1 + 1.1的运算结果就是一个Double类型的2.1.  而有些时候, 我们会涉及到一些类似于"四舍五入"的动作, 要把一个小数转换成整数再来计算.  这些内容就是Scala中的类型转换.

> Scala中的类型转换分为`值类型的类型转换`和`引用类型的类型转换`, 这里我们先重点介绍:`值类型的类型转换`.  
>
> 值类型的类型转换分为:
>
> * 自动类型转换
> * 强制类型转换

#### 7.2 自动类型转换

1. 解释

   范围小的数据类型值会自动转换为范围大的数据类型值, 这个动作就叫: 自动类型转换.

   `自动类型转换从小到大分别为:Byte, Short, Char -> Int -> Long -> Float -> Double `

2. 示例代码

   ```Scala
   val a:Int = 3
   val b:Double = 3 + 2.21	//因为是int类型和double类型的值进行计算, 所以最终结果为: Double类型
   val c:Byte = a + 1	//这样写会报错, 因为最终计算结果是Int类型的数据, 将其赋值Byte类型肯定不行.
   ```

#### 7.3 强制类型转换

1. 解释

   范围大的数据类型值通过一定的格式(强制转换函数)可以将其转换成范围小的数据类型值, 这个动作就叫: 强制类型转换.

   `注意: 使用强制类型转换的时候可能会造成精度缺失问题!`

2. 格式


```Scala
val/var 变量名:数据类型 = 具体的值.toXxx		//Xxx表示你要转换到的数据类型
```

3. 参考代码

```scala
val a:Double = 5.21
val b:Int = a.toInt
```

#### 7.4 值类型和String类型之间的相互转换

**1. 值类型的数据转换成String类型**

**格式一**:

```Scala
val/var 变量名:String = 值类型数据 + ""
```

**格式二**: 

```scala
val/var 变量名:String = 值类型数据.toString
```

**示例**

将Int, Double, Boolean类型的数据转换成其对应的字符串形式.

**参考代码**:

```scala
val a1:Int = 10
val b1:Double = 2.1
val c1:Boolean = true

//方式一: 通过和空字符串拼接的形式实现
val a2:String = a1 + ""
val b2:String = b1 + ""
val c2:String = c1 + ""

//方式二: 通过toString函数实现
val a3:String = a1.toString
val b3:String = b1.toString
val c3:String = c1.toString
```

**2. String类型的数据转换成其对应的值类型**

**格式:**

```scala
val/var 变量名:值类型 = 字符串值.toXxx	//Xxx表示你要转换到的数据类型
```

> 注意:  
>
> * String类型的数据转成Char类型的数据, 方式有点特殊, 并不是调用toChar, 而是toCharArray
> * 这点目前先了解即可, 后续我们详细解释

**需求:**

​	将字符串类型的整数, 浮点数, 布尔数据转成其对应的值类型数据.

**参考代码:**

```scala
val s1:String = "100"
val s2:String = "2.3"
val s3:String = "false"

//将字符串类型的数据转成其对应的: Int类型
val a:Int = s1.toInt
//将字符串类型的数据转成其对应的: Double类型
val b:Double = s2.toDouble
//将字符串类型的数据转成其对应的: Boolean类型
val c:Boolean = s3.toBoolean
```


### 8. 键盘录入

#### 8.1 概述

前边我们涉及到的数据, 都是我们写"死"的, 固定的数据, 这样做用户体验并不是特别好.  那如果这些数据是由用户录入, 然后我们通过代码接收, 就非常好玩儿了. 这就是接下来我们要学习的Scala中的"键盘录入"功能.

#### 8.2 使用步骤

1. 导包

   > 格式: import scala.io.StdIn

2. 通过`StdIn.readXxx()`来接收用户键盘录入的数据

   > 接收字符串数据:  StdIn.readLine()
   >
   > 接收整数数据:  StdIn.readInt()
   > Double, Boolean同理

#### 8.3 示例

- 提示用户录入字符串, 并接收打印.

  ```Scala
  println("请录入一个字符串: ")
  val str = StdIn.readLine()
  println("您录入的字符串内容为: " + str)
  ```

- 提示用户录入整数, 并接收打印.

  ```scala
  println("请录入一个整数: ")
  val num = StdIn.readInt()
  println("您录入的数字为: " + num)
  ```


### 9. 案例: 打招呼

#### 9.1 概述

聊了这么久, 赶紧来和小伙伴儿们来打个招呼吧. 

需求:  提示用户录入他/她的姓名和年龄, 接收并打印.

#### 9.2 具体步骤

1. 提示用户录入姓名.
2. 接收用户录入的姓名.
3. 提示用户录入年龄.
4. 接收用户录入的年龄.
5. 将用户录入的数据(姓名和年龄)打印到控制台上.

#### 9.3 参考代码

```Scala
//1. 提示用户录入姓名.
println("请录入您的姓名: ")
//2. 接收用户录入的姓名.
val name = StdIn.readLine()
//3. 提示用户录入年龄.
println("请录入您的年龄: ")
//4. 接收用户录入的年龄.
val age = StdIn.readInt()
//5. 将用户录入的数据(姓名和年龄)打印到控制台上.
println(s"大家好, 我叫${name}, 我今年${age}岁了, 很高兴和大家一起学习Scala!")
```