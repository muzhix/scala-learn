import java.beans.BeanProperty

object charpter05 {

  def question1(): Unit = {
    class Counter {
      private var value = 0

      def increment(): Unit = {
        if (value == Int.MaxValue) value else value += 1
      }

      def current: Int = value

      def set(n: Int): Unit = {
        value = n
      }
    }
    val c = new Counter
    c.set(Int.MaxValue)
    c.increment()
    println(c.current)
  }

  def question2(): Unit = {
    class BankAccount {
      private var _balance: Double = 0.0

      def deposit(num: Double): Unit = {
        _balance += num
      }

      def withdraw(num: Double): Unit = {
        _balance -= num
      }

      def balance: Double = _balance
    }
    val bc = new BankAccount
    bc.deposit(123)
    bc.withdraw(100.5)
    println(bc.balance)
  }

  /** 3 */
  def question3(): Unit = {
    class Time(h: Int, m: Int) {
      if (h < 0 || h > 23 || m < 0 || m > 59) {
        throw new IllegalArgumentException
      }
      private val hour: Int = h
      private val minute: Int = m

      def before(t: Time): Boolean = {
        if (hour < t.hour) true
        else if (hour > t.hour) false
        else if (minute < t.minute) true
        else false
      }

      def <(t: Time): Boolean = before(t)
    }
    println(new Time(1, 2) < new Time(3, 4))
  }

  def question4(): Unit = {
    class Time(h: Int, m: Int) {
      if (h < 0 || h > 23 || m < 0 || m > 59) {
        throw new IllegalArgumentException
      }
      private val hour: Int = h
      private val minute: Int = m

      def before(t: Time): Boolean = {
        return (h * 60 + m) < (t.hour * 60 + t.minute)
      }

      def <(t: Time): Boolean = before(t)
    }
    println(new Time(1, 2) < new Time(3, 4))
  }

  def question5(): Unit = {
    //    bytecode
    //    public class Student {
    //      private java.lang.String name;
    //      private long id;
    //      public java.lang.String name();
    //      public void name_$eq(java.lang.String);
    //      public long id();
    //      public void id_$eq(long);
    //      public long getId();
    //      public java.lang.String getName();
    //      public void setId(long);
    //      public void setName(java.lang.String);
    //      public Student(java.lang.String, long);
    //    }

    class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {}
    var s = new Student("tom", 12345)
    s.name = "jerry"
    s.id = 2345
    println(s.name)
    println(s.id)
  }

  def question6(): Unit = {
    class Person(var age: Int) {
      if (age < 0) age = 0
    }
    var p = new Person(-1)
    println(p.age)
  }

  def question7(): Unit = {
    class Person(name: String) {
      val firstName: String = name.split(" ")(0)
      val lastName: String = name.split(" ")(1)
    }
    var p = new Person("Fred Smith")

    println(p.firstName)
    println(p.lastName)
  }

  def question8(): Unit = {
    class Car(val producer: String, val model: String, val year: Int = -1, val code: String = ""){}
  }

  def main(args: Array[String]): Unit = {
    //    question1()
    question7()
  }
}
