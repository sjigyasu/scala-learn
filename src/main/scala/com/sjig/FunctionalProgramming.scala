package com.sjig

object FunctionalProgramming extends App {

  // scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }
  val bob = new Person("bob")
  bob.apply(43)
  bob(43)

  // Functional programming:
  // - compose functions
  // - pass functions as args
  // - return functions as results

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23)
  simpleIncrementer(23)

  // All scala functions are instances of these Function_X types

  // FunctionX = Function1, Function2, ...Function22

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String) : String = arg1 + arg2
  }
  stringConcatenator("I love", " scala ")

  // syntax sugars
  // Sugar-1 : Shorthand for apply method
  //           // FUNCTION1         // Arg of apply //
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(4)

  /* THE ABOVE IS SHORTHAND FOR
  new Function1[Int, Int] {
  override def apply(arg1: Int) = 2 * x
   */

  // Sugar-2: Shorthand for Function1
  val doubler2: Int => Int = (x: Int) => 2*x


  // Functions that take functions as arguments or return functions as results
  // are called higher order functions
  val aMappedList = List(1,2,3).map( x => x+1) // higher order function
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2*x))
  println(aFlatMappedList)

  // alternative syntax
  val aFlatMappedList2 = List(1,2,3).flatMap { x =>
    List(x, 2*x)
  }

  // Another classical higher order function
  val aFilteredList = List(1,2,3,4,5).filter( x => x <=3)
  println(aFilteredList)

  // Even shorter syntax
  var aFilteredList2 = List(1,2,3,4,5).filter(_ <= 3) // Equivalent to x => x<=3
  println(aFilteredList2)

  // Chaining
  // e.g. all pairs between numbers 1,2,3 and letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map((letter => s"$number-$letter")))
  println(allPairs)

  // since the above is hard to read, scala has what is known as "for comprehension"
  // this is not a for loop but a for comprehension which is an expression
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatmap chain above

  println(alternativePairs)

  // lists
  val aList = List(1,2,3,4,5)
  val first = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // :: operator is applicable to a list
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)


  // sequences
  val aSequence : Seq[Int] = Seq(1,2,3) // Seq.apply because Seq has a companion object
  val accessedElement = aSequence.apply(1)
  // or
  val accessedElement2 = aSequence(1) // element at index 1

  // vectors -- fast sequence implementation
  val aVector = Vector(1,2,3,4,5)

  // sets
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // + is actually a method name
  val aRemovedSet = aSet - 3 // - is actually a method name

  // ranges - used for "iteration"
  val aRange = 1 to 1000
  val twoByTwo = aRange.map( x => 2*x).toList // List (2,4,6,8...,2000)

  // tuples -- groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook :Map[String, Int] = Map(
    ("Daniel", 123123),
    ("Jane", 12231)
  )
}
