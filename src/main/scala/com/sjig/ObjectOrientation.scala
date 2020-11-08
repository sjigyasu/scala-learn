package com.sjig

object ObjectOrientation extends App{

  // class
  class Animal {
    // define fields
    val age: Int = 0
    def eat() = println("I am eating")
  }

  // instance
  val anAnimal = new Animal

  // inheritance
  // constructor argument - also a constructor definition
  class Dog (name: String) extends Animal

  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields

  // If you want the arg as the field also, put val before constructor argument
  class Cat (val name : String) extends Animal

  val aCat = new Cat("Tom")
  println(aCat.name)

  // subtype polymorphism
  val aDeclaredAnimal:Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true
    def walk() : Unit  // abstract method
  }

  // All fields and methods are PUBLIC by default
  // you can change by specifying private or protected

  // interface
  trait Carnivore {
    def eat(animal : Animal) : Unit
  }

  trait SomeOtherTrait {

  }

  trait Philosopher {
    def ?!(thought : String) : Unit // ?! is a valid method name
  }


  // single-class inheritance and multi traits : "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    // override
    override def eat(animal: Animal): Unit = println("I am eating you, animal")

    override def ?!(thought: String): Unit = println(s"I was thinking : $thought")
  }


  // method notations and method naming
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation --- object method argument --- only available for methods with one argument
  aCroc ?! "What if we could fly"

  // operators in scala are actually methods
  val basicMath = 1 + 2 // + is actually a method
  val anotherBasicMath = 1.+(2) // is equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  } // creates an anonymous class that implements Carnivore trait

  // singleton object
  object mySingleton { // the only instance of mySingleton type
    val mySpecialValue = 12345
    def mySpecialMethod() : Int = 4343
    def apply(x: Int) : Int = x+1 // A special method
  }

  mySingleton.mySpecialMethod()
  mySingleton.apply(65)
  mySingleton(65) // equivalent because the apply method is present
  // Very useful trick in functional programming
  // Presence of apply method allows instances of a class to be invoked like functions

  object Animal {  // Companion object.  Has same name as existing class or trait
    // Companions can access each other's private fields or methods
    // Singleton Animal and instances of Animal are different things
    // Usually you use Animal object to do what Animal instances cannot do
    val canLiveIndefinitely = false
  }
  val animalsCanLiveForever = Animal.canLiveIndefinitely // much like static fields or methods in Java

  // case classes
  // Lightweight data structures with some boilerplate
  case class Person(name : String, age : Int)
  // the compiler generates :
  //  - a sensible equals and hashcode
  //  - serialization
  //  - companion with apply

  // may be constructed without the keyword new
  val bob = Person("bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    val x: String = null
    x.length
  } catch { // catch doesn't take arguments like in Java
    case e: Exception => "some faulty error message"
  } finally {
    // executed no matter what
    // any cleanup
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // This is the list companion object called with apply()
  val first = aList.head // int
  val rest = aList.tail

  val aStringList = List("hello", "scala")
  val firstString = aStringList.head // string

  // Point#1: In scala we operate with immutable values/objects
  // Any modification to an object must return another object
  // Benefits:
  // 1. works miracles in multithreaded/distributed environment
  // 2. helps make sense of the code -- reasoning about
  val reverseList = aList.reverse // this returns a new list

  // Point#2: Scala is closest to the OO ideal

}
