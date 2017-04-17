package com.javarush.task.task37.task3712;

/**
 * Created by Alexey Vedensky on 17.04.2017.
 * MAIL: avedensky@gmail.com
 */
public abstract class Game {
    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run () {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }

}
