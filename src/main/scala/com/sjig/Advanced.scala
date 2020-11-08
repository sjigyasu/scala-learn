package com.sjig

import scala.concurrent.Future
import scala.util.Try
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2

  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }
  val eagerValue = lazyValueWithSideEffect + 1

  // lazy evaluation is useful in infinite collections

  // "pseudo-collections" : Option, Try
  def methodWhichCanReturnNull(): String = "hello scala"
  if (methodWhichCanReturnNull() == null) {
    // defensive code against null
  }

  val anOption = Option(methodWhichCanReturnNull()) // Some("hello scala")
  // option --- think of it as a kind of collection which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException() : String = throw new RuntimeException
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against this evil exception"
  }

  // the try "pseudo collection"
  val aTry = scala.util.Try(methodWhichCanThrowException())
  // a Try is a "collection" with either a value if the code went well or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case scala.util.Success(validValue) => s"I have obtained a valid string: $validValue"
    case scala.util.Failure(exception) => s"I have obtained an exception: $exception"
  }

  /**
   * Asynchronous programming
   */
  val aFuture = Future({ // Future.apply()
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  })
  Thread.sleep(2000)

  // The parentheses can be omitted
  val aFuture2 = Future { // Future.apply()
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }

  // Future, Try and Option types are called monads

  // implicits
  // Use case-1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs with myImplicitIng


  // Use case-2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // can do this even though 23 which is an Int does not have isEven() method

  // Use implicits with a lot of care
}
