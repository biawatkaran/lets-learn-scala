package com.scala.exercise.partial.functions

import akka.actor.{Props, ActorSystem, ActorRef, Actor}

case object GetMessages
case class Messages(msg: List[String])
case class Remove(who: ActorRef)
case class Add(who: ActorRef)

class ChatServer extends Actor {

  private var chats: List[String] = Nil
  private var listeners: List[ActorRef] = Nil

  def receive = {
    case _ => calcReact
  }

  private def calcReact = {

    val handle: PartialFunction[Any, Unit] = {

      case s: String => chats = s :: chats
        notifyListeners()

      case GetMessages => Messages(chats)

    }

    val mgmt: PartialFunction[Any, Unit] = {
      if(chats.length < 3)
        Map.empty
      else{
        case Add(who) => listeners = who :: listeners
          who ! Messages(chats)
        case Remove(who) => listeners = listeners.filter(_ != who)
      }
    }

    handle orElse mgmt

  }

  def notifyListeners(): Unit = {
    listeners.foreach(a => a ! Messages(chats))
  }


}

object PartialFunctionSmoosh {

  def main(args: Array[String]) {

    val system = ActorSystem("TestSmoosh")

    val actor = system.actorOf(Props(new ChatServer))

    actor ! "Karan"

  }
}
