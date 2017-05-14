package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Vedensky on 14.05.2017.
 * MAIL: avedensky@gmail.com
 */
public class LevelLoader {
    public LevelLoader(Path levels) {
    }

    //10.3. Добавь в класс LevelLoader метод GameObjects getLevel(int level). Пока не важно, что будет возвращать
    // этот метод. Пусть он всегда возвращает набор из: одного игрока, одного дома, одного ящика и нескольких стен.
    // Так будет проще отладить работу игры. Координаты каждого объекта должны быть не нулевыми и кратными половине
    // FIELD_CELL_SIZE (центр каждого объекта должен быть в середине ячейки поля).
    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));
        walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));
        walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));
        walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));

        Set<Home> homes = new HashSet<>();
        homes.add(new Home(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2));

        Player player = new Player(Model.FIELD_CELL_SIZE / 2 , Model.FIELD_CELL_SIZE / 2);

        GameObjects gameObjects = new GameObjects(walls, boxes, homes, player);
        return gameObjects;

    }
}
