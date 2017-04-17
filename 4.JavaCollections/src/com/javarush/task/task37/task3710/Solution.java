package com.javarush.task.task37.task3710;

import com.javarush.task.task37.task3710.decorators.RedShapeDecorator;
import com.javarush.task.task37.task3710.shapes.Circle;
import com.javarush.task.task37.task3710.shapes.Rectangle;
import com.javarush.task.task37.task3710.shapes.Shape;

/* 
Decorator

Создай класс RedShapeDecorator в пакете Decorators. Он должен расширять функциональность
объектов типа Shape не меняя их структуру.

Я уже создал абстрактный класс ShapeDecorator, поэтому:
1) Класс RedShapeDecorator сделай наследником класса ShapeDecorator.
2) Реализуй приватный метод setBorderColor с одним параметром типа ShapeDecorator.
Он должен выводить на экран фразу «Setting border color for XXX to red.«,
где XXX — имя конкретного декорируемого класса (можешь воспользоваться методами getClass().getSimpleName()
вызванными на объекте полученном в качестве параметра).
3) Переопредели метод draw, в нем сначала измени цвет отображаемого объекта с помощью
метода setBorderColor, а потом нарисуй его.


Требования:
1. Класс RedShapeDecorator должен быть потомком класса ShapeDecorator.
2. Метод setBorderColor должен выводить на экран фразу соответствующую условию задачи.
3. Метод setBorderColor должен быть приватным.
4. В методе draw класса RedShapeDecorator должен быть изменен цвет декорируемого объекта и вызван его метод draw.
5. Публичный конструктор класса RedShapeDecorator должен принимать один параметр типа Shape.
*/
public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}
