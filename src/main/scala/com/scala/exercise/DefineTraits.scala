package com.scala.exercise
/**
 * Created by karandeep.biawat on 06/11/2014.
 */

trait A

trait B {
  def B() : String
}

trait C extends B{
  override def B(): String = "I'm in C now"
}

trait D{
  def introduce() : String = "Hello From D"
}


class Test extends C with D

object DefineTraits {
  def main(args: Array[String]): Unit = {
    print((new Test).introduce())
  }
}




