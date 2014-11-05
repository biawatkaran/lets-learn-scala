import scala.io._

def toInt(in: String): Option[Int] =
try {
  Some(Integer.parseInt(in.trim))
} catch {
  case e : NumberFormatException => None
}

def sum(in: Seq[String]) = {
  val ints = in.flatMap(s => toInt(s))
  ints.foldLeft(0)((a,b) => a+b)
}

println("Please enter line containing numbers to add : when finish press ctrl+c")
//val input = Source.fromInputStream(System.in) input.getLines().toSeq

val lines = Seq("first number 1", "2", "2")

println("Sum would be :" + sum(lines))