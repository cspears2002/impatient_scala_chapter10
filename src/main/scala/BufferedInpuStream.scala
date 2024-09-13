package bufferedInputStream:

    import java.io.InputStream
    import java.io.BufferedInputStream

    trait BufferedInpuStream(inp: InputStream) extends InputStream {
        val bufferedReader = BufferedInputStream(inp)
        override def read(): Int = bufferedReader.read()
    }