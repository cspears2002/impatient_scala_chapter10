import rectangleLike.*
import orderedPoint.*

@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  makeAnEgg()
  comparePts()


def msg = "I was compiled by Scala 3. :)"


def makeAnEgg(): Unit =
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.iAmRectangleLike()

  val oldX = egg.getX()
  val oldY = egg.getY()
  println(s"Egg X: $oldX")
  println(s"Egg Y: $oldY")
  egg.translate(10, -10)
  val newX = egg.getX()
  val newY = egg.getY()
  println(s"Translated Egg X: $newX")
  println(s"Translated Egg Y: $newY")

  val oldW = egg.getWidth()
  val oldH = egg.getHeight()
  println(s"Egg Width: $oldW")
  println(s"Egg Height: $oldH")
  egg.grow(10, 20)
  val newW = egg.getWidth()
  val newH = egg.getHeight()
  println(s"Egg Width: $newW")
  println(s"Egg Height: $newH")


def comparePts(): Unit =
  val point1 = new java.awt.Point(2, 3) with OrderedPoint
  val point2 = new java.awt.Point(1, 2) with OrderedPoint
  val comp = point2.compare(point1)
  println(s"point2 <= point1: $comp")
