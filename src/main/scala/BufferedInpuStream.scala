package buffering:

    import java.io.FileInputStream
    import java.io.BufferedInputStream

    trait Buffering {
        this: FileInputStream =>
            val b = BufferedInputStream(this)
            override def read(ab: Array[Byte]): Int = {
                b.read(ab)
            }
    }
