package com.scala.exercise

/**
 * Created by karandeep.biawat on 10/11/2014.
 */

class PassFunctions {

  /*
  When passing function treated as anonymous class implementing trait(interface) having apply method
  e.g.
    Function[A,B]
      A - parameter type
      B - return type

      Function.apply(p: A) : B
   */

  //*******************************************************************
  // these three methods are way to use apply method as param check in main method
  def passFunctionsMethod1(f : Function1[Int,String])= f.apply(42)

  def passFunctionsMethod2(f: Int => String) = f.apply(42)

  def passFunctionsInCaseObjectHasApplyMethod(f: Int => String) = f(42)

  def apply(p: Int): String = {
    p.toString
  }

  def unapply(p: String) : Int = {
    Integer.parseInt(p)
  }


  //*******************************************************************
  // pass a function that accepts nothing and returns nothing
  def passFunctions(callback: () => Unit){
    while(true){
      callback()
      Thread.sleep(1000)
    }
  }

  def timeFlies() = {
    println("time flies...")
  }

}

object TestPassFunctions {
  //*******************************************************************

  def main(args: Array[String]) {

    val obj2 = new PassFunctions
    //obj2.passFunctions(obj2.timeFlies)

    println(obj2.passFunctionsMethod1(obj2.apply))
    println(obj2.passFunctionsMethod2(obj2.apply))
    println(obj2.passFunctionsInCaseObjectHasApplyMethod(obj2.apply))

  }
}