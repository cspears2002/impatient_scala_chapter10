package buffering:

    import logger.Logger
    import java.io.FileInputStream
    import java.io.BufferedInputStream

    trait Buffering extends Logger {
        this: FileInputStream =>
            val b = BufferedInputStream(this)
            override def read(ab: Array[Byte]): Int = {
                b.read(ab)
            }
            override def log(msg: String): Unit = {
                print(msg)
            }
    }
