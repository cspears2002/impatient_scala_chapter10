package dog:

    trait Dog {
        val color = "black"
        
        def bark(msg: String): Unit
        def wag() = println("Wagging tail!")
    }
