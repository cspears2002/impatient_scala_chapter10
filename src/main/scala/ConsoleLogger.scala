package consoleLogger:

    import logger.Logger

    trait ConsoleLogger extends Logger:
        val logId = 5678
        def log(msg: String) = println(msg)