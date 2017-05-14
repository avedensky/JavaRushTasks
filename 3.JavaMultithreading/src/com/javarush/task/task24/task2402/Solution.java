package com.javarush.task.task24.task2402;

/* 
Cloneable

Добавьте java-код, чтобы метод main отработал без исключений.


Требования:
1. Класс Test4 должен поддерживать интерфейс Cloneable.
2. В классе Test4 должен быть реализован метод clone() без параметров.
3. В методе main должен быть вызван метод clone на объекте типа Test1.
4. В методе main должен быть вызван метод clone на объекте типа Test2.
5. В методе main должен быть вызван метод clone на объекте типа Test4.
6. В методе main должен быть вызван метод c1one на объекте типа Test3.
7. Класс Test1 должен поддерживать интерфейс Cloneable.
*/
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 test1 = new Test1();
        test1.clone();

        Test2 test2 = new Test2();
        test2.clone(new Test2());

        Test3 test3 = new Test3();
        test3.c1one();

        Test4 test4 = new Test4();
        test4.clone();
    }


    public static class Test1 implements Cloneable {
        protected Test1 clone() throws CloneNotSupportedException {
            return (Test1)super.clone();
        }
    }

    public static class Test2 extends Test1 {
        public Test2 clone(Test2 test2) throws CloneNotSupportedException {
            return (Test2)test2.clone();
        }
    }

    public static class Test3 implements Cloneable {
        protected Object c1one() throws CloneNotSupportedException {
            return new Test3();
        }
    }

    public static class Test4 extends Test3 implements Cloneable {
        protected Test4 clone() throws CloneNotSupportedException {
            return (Test4)super.clone();
        }
    }
}
