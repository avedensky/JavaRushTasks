package com.javarush.task.task23.task2312;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс программы.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     * <p>
     * Теперь поработаем над методом print().
     * <p>
     * Надо:
     * а) вывести на экран прямоугольник из точек размером width x height.
     * б) тело змеи отметить символом «x«-английское
     * в) голову змеи нарисовать символом «X«-английское.
     * <p>
     * Подсказка:
     * а) удобно сначала создать матрицу типа int[][] с размером (height x width)
     * б) затем пройтись по всем объектам и отрисовать их в матрицу.
     * Например, тело змеи — 1, голова змеи — 2, мышь — 3.
     * <p>
     * <p>
     * Требования:
     * 1. Метод print должен выводить данные на экран.
     * 2. Метод print должен выводить на экран количество строк равное height.
     * 3. Количество символов в каждой строке выведенной на экран должно быть равно width.
     * 4. Голова змеи должна быть отмечена символом X.
     * 5. Тело змеи должно быть отмечено символами x.
     * 6. Мышь должна быть отмечена символом ^.
     */
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        //Рисуем все кусочки змеи
        //Рисуем мышь
        //Выводим все это на экран
        //Создаем массив, куда будем "рисовать" текущее состояние игры

        int[][] screen = new int[height][width];
        List<SnakeSection> snakeSections = snake.getSections();

        for (SnakeSection snakeSection : snakeSections)
            screen[snakeSection.getY()][snakeSection.getX()] = 1;

        screen[snake.getY()][snake.getX()] = 2;
        screen[mouse.getY()][mouse.getX()] = 3;

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (screen[j][i] == 1)
                    System.out.print("x");
                else if (screen[j][i] == 2)
                    System.out.print("X");
                else if (screen[j][i] == 3)
                    System.out.print("^");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static Room game;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Программа делает паузу, длинна которой зависит от длинны змеи.
     */


//    Предлагаю тебе в этот раз написать специальный метод sleep(), который будет делать паузу
//  в зависимости от длины змеи (количества элементов в sections).
//    Придумай какой-нибудь хитрый алгоритм. Чтобы на первом уровне пауза была 500 миллисекунд,
//    а к 10 уровню постепенно уменьшилась до 300. А к 15 до 200. И дальше оставалась постоянной.
//
//
//    Требования:
//            1. Метод sleep должен вызывать метод Thread.sleep(500) в начале игры.
//            2. Метод sleep должен вызывать метод Thread.sleep(300) на 11 уровне.
//3. Метод sleep должен вызывать метод Thread.sleep(200) для уровней больше 15.
    public void sleep() {
        int pause = 0;
        int section = snake.getSections().size();

        if (section < 17)
            pause = 520 - section * 20;

        if (section > 15)
            pause = 200;
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
