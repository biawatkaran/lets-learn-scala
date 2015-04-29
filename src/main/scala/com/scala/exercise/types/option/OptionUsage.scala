package com.scala.exercise.types.option

import java.lang.{Boolean => JBool}
/**
 * Created by Beauty on 11/20/14.
 */
object OptionUsage {

  def main(args: Array[String]) {

    println(toInt("1"))

    println(toBool("1==1"))
  }

  //*************************************
  //********* util **********************
  def tryo[T](f: => T) : Option[T] ={
    try{
      Some(f)
    } catch {
      case _ : Throwable => None
    }
  }

  //************** helpers ***************
  def toInt(s: String) : Option[Int] = {
    tryo(s.toInt)
  }

  def toBool(s: String) = {
    tryo(JBool.parseBoolean(s))
  }

  //***************************************
}
