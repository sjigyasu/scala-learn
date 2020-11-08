package com.sjig

object PatternMatching extends App {

  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => anInteger + "th"
  }
  println(order)

  // the pattern match is actually an expression
  // so it can be reduced to a value

  // Case class decomposition
  case class Person(name : String, age : Int)

  val bob = Person("Bob", 43) // case class has companion object

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }
  println(personGreeting)

  // Deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")

  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to $genre"
    case _ => "I don't know what you're talking about"
  }

  // "If tuple conforms to some structure then do something"

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_,2,_) => "List containing 2 in its second position"
    case _ => "unknown list"
  }


}
