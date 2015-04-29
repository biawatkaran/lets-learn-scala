package com.scala.exercise.pattern.matching.lists


/**
 * Created by Beauty on 4/28/15.
 */
object PatternMatchingList {

  def main(args: Array[String]) {

    val x = 1
    val rest = List(2, 3, 4)

    println(x :: rest)

    x :: rest match {

      case xprime :: restprime => println(xprime); println(restprime)

    }
  }
}
