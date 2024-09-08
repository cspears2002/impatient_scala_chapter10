import logger.*
import orderedPoint.*
import propertyChangeSupport.*
import rectangleLike.*
import consoleLoggedAccount.ConsoleLoggedAccount


@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  makeAnEgg()
  comparePts()

  val plainText = "The quick brown fox jumps over the lazy dog"
  val encryptMessage = EncryptMessage()
  encryptMessage.encryptMsg(plainText, -3)
  val encryptedMsg = "qeb nrfzh yoltk clu grjmp lsbo qeb ixwv ald"
  encryptMessage.encryptMsg(encryptedMsg, 3)

  val listener = PointPropertyListener()
  val point = MyPoint(0, 0)

  point.addPropertyChangeListener(listener)
  var listeners = point.getPropertyChangeListeners()
  println(s"I am listening with ${listeners.length} listeners")
  point.setX(1.0)
  point.removePropertyChangeListener(listener)
  listeners = point.getPropertyChangeListeners()
  println(s"I am listening with ${listeners.length} listeners")

  point.addPropertyChangeListener("y", listener)
  listeners = point.getPropertyChangeListeners("y")
  println(s"I am listening with ${listeners.length} listeners")
  point.setX(1.0)
  point.setY(1.0)
  point.removePropertyChangeListener("y", listener)
  listeners = point.getPropertyChangeListeners("y")
  println(s"I am listening with ${listeners.length} listeners")

  makeAnAccount


def msg = "I was compiled by Scala 3. :)"


def makeAnAccount: Unit =
  val myAccount = ConsoleLoggedAccount()
  val myId = myAccount.id
  println(s"This is my account id: $myId")
  val myLogId = myAccount.logId
  println(s"This is my log id: $myLogId")


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
  val pt1 = new OrderedPoint(1, 1)
  val pt2 = new OrderedPoint(1, 2)
  assert(pt1 < pt2)

  val pt3 = new OrderedPoint(1, 1)
  val pt4 = new OrderedPoint(2, 1)
  assert(pt3 < pt4)


class EncryptMessage extends CryptoLogger

