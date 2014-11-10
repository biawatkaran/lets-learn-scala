package com.excelian

/**
 * Created by karandeep.biawat on 10/11/2014.
 */

object CallByName {

  def toBeCalled() = {
    println("called method")
    System.nanoTime()
  }

  def callByRef(t : Long) = {
    println("call by ref method")
    println("param :" + t)
    t
  }

  def callByName(t : => Long) = {
    println("call by name method")
    println("param :" + t)
    t
  }
}

