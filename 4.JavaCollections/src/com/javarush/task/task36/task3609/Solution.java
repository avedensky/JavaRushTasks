package com.javarush.task.task36.task3609;

/* 
Рефакторинг MVC

Перемести некоторые методы в нужные классы, что бы получить паттерн MVC.
Если необходимо — внеси изменения в метод main, которые отражают внесенные тобой изменения.
Поведение программы при этом не должно измениться.
НЕ изменяй названия классов, методов и полей.


Требования:
1. Вывод программы должен остаться без изменений.
2. Необходимо переместить метод void speedUp(int) из класса CarModel в класс CarController.
3. Необходимо переместить метод void speedDown(int) из класса CarModel в класс CarController.
4. В методе main класса Solution метод speedUp необходимо вызывать у контроллера, а не у модели.
5. В методе main класса Solution метод speedDown необходимо вызывать у контроллера, а не у модели.
*/

public class Solution {
    public static void main(String[] args) {
        //Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();

        //Create a view : to show car's speed on speedometer(console)
        SpeedometerView view = new SpeedometerView();

        CarController controller = new CarController(model, view);
        controller.updateView();

        //Update model data
        controller.speedUp(15);
        controller.updateView();

        //Update model data
        controller.speedUp(50);
        controller.updateView();

        //Update model data
        controller.speedDown(7);
        controller.updateView();
    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera classic");
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);
        return currentCar;
    }
}