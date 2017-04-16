package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    //1) int size() — должен возвращать количество значений в нашей коллекции.
    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

//    2) V put(K key, V value) — должен добавить элемент value по ключу key. Если в мапе такой ключ уже есть,
//    и количество значений по этому ключу меньше, чем repeatCount — то добавь элемент value в конец листа
//    в объекте map. Если по такому ключу количество значений равняется repeatCount — то удали из листа в
//    объекте map элемент с индексом ноль, и добавь в конец листа value. Метод должен возвращать значение
//    последнего добавленного элемента по ключу key (но не значение, которое мы сейчас добавляем).
//    Если по ключу key значений еще нет — верни null.
    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        V oldValue = null;

        if (values == null) {
            values = new ArrayList<>();

        } else {
            oldValue = values.get(values.size()-1);
            if (values.size() == repeatCount)
                values.remove(0);
        }

        values.add(value);
        map.put(key, values);
        return oldValue;

    }

//    3) V remove(Object key) — должен удалить элемент по ключу key. Если по этому ключу хранится несколько
//    элементов — должен удаляться элемент из листа с индексом ноль. Если по какому-то ключу хранится лист
//    размером ноль элементов — удали такую пару ключ : значение. Метод должен возвращать элемент, который ты удалил.
//    Если в мапе нет ключа key — верни null.
    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        if (values == null)
            return null;

        V storeValue = values.get(0);
        values.remove(0);

        if (values.size() == 0)
            map.remove(key);

        return storeValue;
    }

    //  4) Set<K> keySet() — должен вернуть сет всех ключей, которые есть в мапе map.
    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    //  5) Collection<V> values() — должен вернуть ArrayList<V> всех значений. Порядок значений в листе не имеет значения.
    @Override
    public Collection<V> values() {
        //напишите тут ваш код
//        ArrayList<V> res = new ArrayList<>();
//        res.addAll((Collection<? extends V>) map.values());

        ArrayList<V> values = new ArrayList<>();
        for (List<V> value : map.values()) {
            values.addAll(value);
        }
        return values;

        //return res;
    }

    //  6) boolean containsKey(Object key) — должен вернуть true, если в мапе присутствует ключ key, иначе вернуть false.
    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return keySet().contains(key);
    }

    //  7) boolean containsValue(Object value) — должен вернуть true, если в мапе присутствует значение value,
    //     иначе вернуть false.
    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}