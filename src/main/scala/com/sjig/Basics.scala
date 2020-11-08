package com.sjig

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42

  val aBoolean = false

  // Strings and string operations
  val aString = "I love scala"
  val aComposedString = "I" + "love" + "scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // Think in terms of values and expressions
  // Expressions are structures that can be reduced to a value
  val anyExpression = 2+3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression = if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife < 999) 78
    else 0

  // Code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // the last expression is the value of the code block
    // Notice that return type is not specified. compiler will infer
    aLocalValue + 3
  }

  // defining functions
  def myFunction(x: Int, y: String) : String = y + "" + x

  // or use a code block

  def myFunction2(x: Int) : String = {
    ""
  }

  // recursive
  def factorial(n : Int) : Int = {
    if (n <=1) 1
    else n * factorial(n-1)
  }
  // In scala we don't use loops or iterations
  // We use recursion
  // Think in terms of functions and recursion

  // Unit return types
  // Unit -- no meaningful value. Similar to void in other languages
  println("I love scala") // Unit type is a type of side-effects
  // Side effects do something and don't return any value.

  def myUnitReturningFunction() : Unit = {
    println("ya ya ya")
    1+3
  }



}
