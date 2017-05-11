package com.javarush.task.task26.task2613;

/**
 * Created by Alexey on 11.05.2017.
 */
// Такое решение не проходит
//enum Operation {
//    INFO, DEPOSIT, WITHDRAW, EXIT;
//
//    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {
//        for (Operation o : Operation.values())
//            if (o.ordinal() == i)
//                return o;
//
//        throw new IllegalArgumentException();
//    }
//}

//A так работает...
public enum Operation {
    INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch (i)
        {
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
