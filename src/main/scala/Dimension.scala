package dimension:

    trait Dim[Seconds](val value: Double, val name: String):
        this: Seconds =>
            protected def create(v: Double): Seconds
            def +(other: Dim[Seconds]) = create(value + other.value)
            override def toString() = s"$value $name"

    class Seconds(v: Double) extends Dim[Seconds](v, "s"):
        override protected def create(v: Double): Seconds = new Seconds(v)
