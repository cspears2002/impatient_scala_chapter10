package aussie:

    import dog.*

    trait AustralianShepherd(name: String) extends dog.Dog {
        val age: Int

        def bark(msg: String): Unit = println(s"Ruff! $msg")

        def doggieName() = println(s"My name is $name.")
    }
