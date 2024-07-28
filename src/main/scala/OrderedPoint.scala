package orderedPoint:

    import java.awt.Point

    class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
        def compare(that: Point): Int =
            if (x < that.x || (x == that.x && y < that.y)) -1
            else if (x == that.x && y == that.y) 0
            else 1
    }
