package consoleLoggedAccount:

    import account.Account
    import consoleLogger.ConsoleLogger

    class ConsoleLoggedAccount extends Account, ConsoleLogger:
        def withdraw(amount: Double) =
            if amount > balance then log("Insufficient funds")
            else balance -= amount