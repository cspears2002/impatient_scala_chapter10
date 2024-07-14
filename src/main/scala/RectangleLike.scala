package rectangleLike:

    import scala.compiletime.ops.double

    trait RectangleLike {
        this: java.awt.geom.Ellipse2D.Double =>
            def iAmRectangleLike(): Unit =
                println("I am rectangle like.")

            def translate(moveX: Double, moveY: Double): Unit
    }
