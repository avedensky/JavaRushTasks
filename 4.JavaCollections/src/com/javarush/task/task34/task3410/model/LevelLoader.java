package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex Vedensky on 14.05.2017.
 * MAIL: avedensky@gmail.com
 */


/*
Осталось дописать реализацию загрузчика уровней.
16.1. Открой файл levels.txt и внимательно изучи структуру файла. Символ ‘X’ – означает стену, ‘*’ — ящик,
‘.’ – дом, ‘&’ – ящик который стоит в доме, а ‘@’ — игрока. Всего в файле 60 уровней.

16.2. Реализуй метод GameObjects getLevel(int level). Он должен:
16.2.1. Вычитывать из файла данные уровня level. Уровни должны повторяться циклически, если пользователь прошел
все 60 уровней и попал на 61 уровень, то ему нужно вернуть 1, вместо 62 уровня вернуть 2 и т.д.
16.2.2. Создать все игровые объекты, описанные в указанном уровне. Координаты каждого игрового объекта должны быть
рассчитаны согласно следующей логике:
16.2.2.1. Самый верхний левый объект (если такой есть) должен иметь координаты
x = x0 = FIELD_CELL_SIZE / 2 и y = y0 = FIELD_CELL_SIZE / 2.
16.2.2.2. Объект, который находится на одну позицию правее от него должен иметь координаты
x = x0 + FIELD_CELL_SIZE и y = y0.
16.2.2.3. Объект, который находится на одну позицию ниже от самого верхнего левого должен иметь координаты x = x0
и y = y0 + FIELD_CELL_SIZE.
16.2.2.4. Аналогично должны рассчитываться координаты любого объекта на поле.
16.2.3. Создать новое хранилище объектов GameObjects и поместить в него все объекты.
16.2.4. Вернуть созданное хранилище.

Игра должна быть полностью рабочей. Проверь, если есть какие-то проблемы исправь их.

*/
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    //10.3. Добавь в класс LevelLoader метод GameObjects getLevel(int level). Пока не важно, что будет возвращать
    // этот метод. Пусть он всегда возвращает набор из: одного игрока, одного дома, одного ящика и нескольких стен.
    // Так будет проще отладить работу игры. Координаты каждого объекта должны быть не нулевыми и кратными половине
    // FIELD_CELL_SIZE (центр каждого объекта должен быть в середине ячейки поля).
    public GameObjects getLevel(int level) {
        {
            Set<Wall> walls = new HashSet<>();
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Player player = null;

            int loopLevel;
            if (level > 60) {
                loopLevel = level % 60;
            } else {
                loopLevel = level;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
                int readLevel = 0;
                int x;
                int y = Model.FIELD_CELL_SIZE / 2;
                boolean isLevelMap = false;

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Maze:")) {
                        readLevel = Integer.valueOf(line.split(" ")[1]);
                        continue;
                    }
                    if (readLevel == loopLevel) {
                        if (line.length() == 0) {
                            boolean isEnd = isLevelMap;

                            isLevelMap = !isLevelMap;

                            if (isEnd && !isLevelMap) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (isLevelMap) {
                            x = Model.FIELD_CELL_SIZE / 2;

                            char[] chars = line.toCharArray();
                            for (char c : chars) {
                                switch (c) {
                                    case 'X':
                                        walls.add(new Wall(x, y));
                                        break;
                                    case '*':
                                        boxes.add(new Box(x, y));
                                        break;
                                    case '.':
                                        homes.add(new Home(x, y));
                                        break;
                                    case '&':
                                        boxes.add(new Box(x, y));
                                        homes.add(new Home(x, y));
                                        break;
                                    case '@':
                                        player = new Player(x, y);
                                }
                                x += Model.FIELD_CELL_SIZE;
                            }
                            y += Model.FIELD_CELL_SIZE;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new GameObjects(walls, boxes, homes, player);
        }
    }
}
