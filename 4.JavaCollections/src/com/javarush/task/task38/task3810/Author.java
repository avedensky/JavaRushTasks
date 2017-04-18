package com.javarush.task.task38.task3810;

public @interface Author {
    //напиши свой код
    String value();
    Position position() default Position.JUNIOR;
}
