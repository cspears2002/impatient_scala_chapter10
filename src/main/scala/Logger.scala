package logger:

    trait Logger:
        def log(msg: String): Unit

    trait CryptoLogger extends Logger:
        def log(msg: String) = println(msg)
        
        def encryptMsg(msg: String, key: Int = 3): Unit =
            val lowerMsg = msg.toLowerCase()
            val lettersArray = ('a' to 'z').toArray
