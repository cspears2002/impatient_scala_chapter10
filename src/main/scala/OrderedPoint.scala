package orderedPoint {

    import java.awt.Point

    trait OrderedPoint extends java.awt.Point {
        this: scala.math.Ordered[Point] =>
            def compare(that: Point) =
                if this.x <= that.x && this.y < that.y then
                    -1
                else
                    1
}