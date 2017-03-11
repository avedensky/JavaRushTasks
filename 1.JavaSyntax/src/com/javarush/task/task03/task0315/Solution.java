package com.javarush.task.task03.task0315;

/* 
Каждый охотник желает знать…
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Red red = new Red ();
        Orange orange = new Orange ();
        Yellow yellow = new Yellow ();
        Green green = new Green ();
        Blue blue = new Blue ();
        Indigo indigo = new Indigo ();
        Violet violet = new Violet ();
    }

    public static class Red {
        public Red() {
            System.out.println("Red");
        }
    }

    public static class Orange {
        public Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow {
        public Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green {
        public Green() {
            System.out.println("Green");
        }
    }

    public static class Blue {
        public Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo {
        public Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet {
        public Violet() {
            System.out.println("Violet");
        }
    }
}
