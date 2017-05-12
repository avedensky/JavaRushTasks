package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;

/**
 * Created by Alexey on 11.05.2017.
 */

/*
1.1. Спросить, действительно ли пользователь хочет выйти — варианты <y,n>.
1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.
1.3. Если пользователь не подтвердит свои намерения, то не прощаться с ним, а просто выйти.
 */
class ExitCommand implements Command {


    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Are you sure want to quit? (y,n):");
        try {
            String s = ConsoleHelper.readString();
            if (s.equalsIgnoreCase("Y")) {
                ConsoleHelper.writeMessage("Bye");
            }
        } catch (InterruptOperationException e) {
            throw new InterruptOperationException ();
        }
    }
}
