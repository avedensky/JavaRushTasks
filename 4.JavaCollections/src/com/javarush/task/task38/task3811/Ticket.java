package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by Alexey Vedensky on 18.04.2017.
 * MAIL: avedensky@gmail.com
 */

/*
Требования к ней следующие:

2) Применяться может только к новым типам данных.
*/

//
@Retention(value= RetentionPolicy.RUNTIME) //1) Должна быть доступна во время выполнения программы.
@Target(ElementType.TYPE)
public @interface Ticket {
    //3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
    public enum Priority {LOW, MEDIUM, HIGH}

    //4) Приоритет будет задавать свойство priority — по умолчанию Priority.MEDIUM.
    Priority priority() default Priority.MEDIUM;

    //5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
    String[] tags() default {};

    //6) Свойство createdBy будет строкой — по умолчанию Amigo.
    String createdBy() default "Amigo";
}
