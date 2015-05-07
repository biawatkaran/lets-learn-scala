package com.scala.exercise.pattern.matching.lists

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
