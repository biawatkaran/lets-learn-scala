package com.scala.exercise.pattern.matching.lists

/**
 * Created by Beauty on 4/29/15.
 */

class MyList[+T] {

  def ?:[B >: T](x : B): MyList[B] = {
    new ?:(x , this)
  }

}

case object MNil extends MyList[Nothing]

case class ?:[T](hd: T, tail: MyList[T]) extends MyList[T]

object CustomScalaList {

  def tryMyList(p : MyList[Any]) = p  match {
    case 1 ?: MNil => "list with MNil"
    case 1 ?: _ => "proper list"
    case _ => "anything"
  }

  def main(args: Array[String]) {

    val nilList = MNil

    val intWithNil = tryMyList(1 ?: nilList)
    println(intWithNil)

    val intList = new MyList()
    intList.?:(1)

    val properList = tryMyList(1 ?: intList)
    println(properList)
  }

}
