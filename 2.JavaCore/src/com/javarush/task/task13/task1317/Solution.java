package com.javarush.task.task13.task1317;

/* 
Погода
1. В классе Today реализовать интерфейс Weather.
2. Подумай, как связан параметр type с методом getWeatherType().
3. Интерфейсы Weather и WeatherType уже реализованы в отдельных файлах.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }


    static class Today implements Weather, WeatherType{
        private String type;

        Today(String type) {
            this.type = type;
        }



        @Override
        public String toString() {
            return String.format("%s for today", this.getWeatherType());
        }

        @Override
        public String getWeatherType() {
            return this.type;
        }
    }
}
