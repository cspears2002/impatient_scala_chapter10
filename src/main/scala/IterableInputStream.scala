package iterInputStr:

    import java.io.InputStream

    class IterableInputStream(private val in: InputStream) extends InputStream with Iterable[Byte] {
        if (in == null) {
            throw new NullPointerException("in")
        }

        override def close(): Unit = in.close()

        override def read(): Int = in.read()

        override def iterator: Iterator[Byte] = new Iterator[Byte] {
            private var nextByte: Int = 0

            override def hasNext: Boolean = {
                if (nextByte != -1) {
                    nextByte = read()
                }
                nextByte != -1
            }

            override def next(): Byte = {
                nextByte.toByte
            }
        }
    }