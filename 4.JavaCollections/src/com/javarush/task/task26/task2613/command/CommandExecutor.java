package com.javarush.task.task26.task2613.command;


import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexey on 11.05.2017.
 */

//Класс CommandExecutor должен содержать приватное статическое поле Map<Operation, Command> allKnownCommandsMap.
public class CommandExecutor{
    private static final Map<Operation, Command> allKnownCommandsMap;

    static {
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(Operation.INFO, (Command) new InfoCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, (Command) new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, (Command) new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, (Command) new ExitCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException, NotEnoughMoneyException {
        allKnownCommandsMap.get(operation).execute();
    }
}
