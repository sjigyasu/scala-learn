package com.sjig

object ExampleWithMain {
  def main(args: Array[String]): Unit = {
    println("This is the main method")

    val numbers = Map("one" -> 1, "two" -> 2)
    println(numbers)
    val two = numbers.get("two")
    println(two)

    val three = numbers.get("three")
    println(three)

    val result= if (three.isDefined) {
      println("yes")
    } else {
      println("no")
    }

    val result2 = three match {
      case Some(n) => "yes"
      case None => "no"
    }
    println(result2)

    two foreach { v => println("Inside foreach" + v)}

    println( three getOrElse "something")
  }

}
