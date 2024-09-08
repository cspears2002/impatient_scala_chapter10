package consoleLogger:

    import logger.Logger

    trait ConsoleLogger extends Logger:
        def log(msg: String) = println(msg)