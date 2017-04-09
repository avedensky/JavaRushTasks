package com.javarush.task.task34.task3408;

/* 
Кэширование

Класс Cache — универсальный параметризированный класс для кеширования объектов.
Он работает с классами (дженерик тип Т), у которых обязан быть:
а) публичный конструктор с одним параметром типа K;
б) метод K getKey() с любым модификатором доступа.

Задание:
1. Выбери правильный тип для поля cache. Map<K, V> cache должен хранить ключи, на которые есть активные ссылки.
Если нет активных ссылок на ключи, то они вместе со значениями должны автоматически удаляться из cache.
2. Реализуй логику метода getByKey:
2.1. Верни объект из cache для ключа key.
2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
3. Реализуй логику метода put:
3.1. Используя рефлексию получи ссылку на метод, описанный в пункте б).
3.2. Используя рефлексию разреши к нему доступ.
3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
3.4. Добавь в кэш пару <key, obj>.
3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.


Требования:
1. Поле cache должно быть инициализировано объектом типа WeakHashMap.
2. Метод getByKey должен возвращать объект из кеша.
3. Метод getByKey должен добавлять объект в кеш если его там нет.
4. Метод put должен извлекать из переданного объекта ключ и добавлять в кеш пару .
5. Метод put должен возвращать true, если он отработал корректно, иначе false.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        SomeKey someKey = new SomeKey();
        someKey.name = "test";

        SomeKey someKeyNew = new SomeKey();
        someKeyNew.name = "testNew";

        SomeValue value = new SomeValue(someKey);

        Cache<SomeKey, SomeValue> cache = new Cache<>();
        cache.put(value);

        SomeValue valueFromCacheExisted = cache.getByKey(someKey, SomeValue.class);
        System.out.println(valueFromCacheExisted);

        SomeValue valueFromCacheNew = cache.getByKey(someKeyNew, SomeValue.class);
        System.out.println(valueFromCacheNew);

        System.out.println(cache.size());
        /* expected output:
        SomeValue{myKey=SomeKey{name='test'}}
        SomeValue{myKey=SomeKey{name='testNew'}}
        2
         */
    }

    public static class SomeKey {
        String name;

        @Override
        public String toString() {
            return "SomeKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class SomeValue {
        private SomeKey myKey;

        public SomeValue() {
        }

        public SomeValue(SomeKey myKey) {        //use this constructor
            this.myKey = myKey;
        }

        private SomeKey getKey() {
            return myKey;
        }

        @Override
        public String toString() {
            return "SomeValue{" +
                    "myKey=" + myKey +
                    '}';
        }
    }
}
