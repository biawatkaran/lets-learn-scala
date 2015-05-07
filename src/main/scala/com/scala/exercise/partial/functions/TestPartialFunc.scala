package com.scala.exercise.partial.functions



class URLHandler {

  def handleRequest(req : List[String])
                   (exceptions : PartialFunction[List[String], String]) : String = {

    if(exceptions.isDefinedAt(req))
      exceptions(req)
    else
      "Handling url in normal way for request :" + req

  }

}

object TestPartialFunc {

  def main(args: Array[String]) {

    val handler = new URLHandler

    val output = handler.handleRequest("foo" :: Nil){

      case "api" :: call :: params => doApiCall(call, params)
      // case "foo" :: Nil => "Doing foo call for "
    }

    println(output)
  }

  private def doApiCall(call: String, params: List[String]): String = {
    "Doing api call for " + call
  }
}
