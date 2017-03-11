package com.javarush.task.task14.task1408;

/**
 * Created by Alexey on 11.03.2017.
 */
public class RussianHen extends Hen{

    public int getCountOfEggsPerMonth() {
        return 10;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }

}
