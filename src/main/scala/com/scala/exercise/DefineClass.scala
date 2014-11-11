package com.scala.exercise

/**
 * Created by karandeep.biawat on 05/11/2014.
 */
class DefineClass(param: String) {
  if(param == null) throw new Exception("No Name")
}

object RunDefineClass extends App {

  val v = new DefineClass(null)

}