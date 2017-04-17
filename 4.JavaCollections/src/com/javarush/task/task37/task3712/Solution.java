package com.javarush.task.task37.task3712;

import java.util.ArrayList;
import java.util.List;

/* 
Шаблонный метод

Классы Football, Basketball и Tennis описывают три популярные игры.
Спроси у своего любимого поисковика о паттерне Template method (Шаблонный метод) и
сделай так, чтобы код написанный в методе main класса Solution имел смысл.

P.S. Класс Game должен быть абстрактным.


Требования:
1. Классы Football, Basketball и Tennis должны быть потомками класса Game.
2. В классе Game должны быть определены три абстрактных метода prepareForTheGame, playGame
и congratulateWinner.
3. В классе Game должен быть реализован метод run, вызывающий методы prepareForTheGame,
playGame и congratulateWinner в правильном порядке.
4. Класс Game должен быть абстрактным.
*/
public class Solution {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        games.add(new Football());
        games.add(new Basketball());
        games.add(new Tennis());

        for(Game game : games) {
            game.run();
            System.out.println("---------------------------------------------");
        }
    }
}
