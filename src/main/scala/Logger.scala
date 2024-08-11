package logger:

    import scala.compiletime.ops.double

    trait Logger:
        def log(msg: String): Unit

    trait CryptoLogger extends Logger:
        def log(msg: String) = println(msg)
        
        def encryptMsg(msg: String, key: Int = 3): Unit =
            val letterToIdxMap = ('a' to 'z').toList.zipWithIndex.toMap
            val idxToLetterMap = ('a' to 'z').toList.zipWithIndex.map(x => (x(1), x(0))).toMap
            for letter <- msg do
                if letterToIdxMap.contains(letter.toLower) then
                    val idx = letterToIdxMap(letter.toLower) + key
                    println(idx)
                else
                    println()

