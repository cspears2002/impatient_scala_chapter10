import rectangleLike.*

@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  makeAnEgg()


def msg = "I was compiled by Scala 3. :)"


def makeAnEgg(): Unit =
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.iAmRectangleLike()
