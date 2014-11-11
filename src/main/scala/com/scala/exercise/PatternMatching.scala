package com.scala.exercise

/**
 * Created by karandeep.biawat on 10/11/2014.
 */
object PatternMatching {

  //*******************************
  def checkClassType(x : Object) : String = {
    x match {
      case d: java.util.Date => "Date: " + d.toString
      case s: String => "String: " +s
      case u: java.net.URL => "URL: " + u.getPath
      case _ => "Something else"
    }
  }

  def main(args: Array[String]) {

    println("Passing Date >>>>>" + checkClassType(new java.util.Date()))
    println("Passing String >>>> " + checkClassType("Karan"))
    println("Passing URL >>>>>" + checkClassType(new java.net.URL("""https://www.google.co.uk""")))
    println("Passing null >>>>>>" + checkClassType(null))
  }
}
