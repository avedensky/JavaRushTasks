package com.javarush.task.task35.task3504;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* 
Простой generics

Параметризируй класс Solution, чтобы он мог работать со всеми классами, которые наследуются от HashMap.
Метод getMap должен возвращать тип поля map.


Требования:
1. Класс Solution должен быть параметризирован типом который является наследником HashMap.
2. В классе Solution должно существовать поле map.
3. В классе Solution должен существовать метод getMap.
4. Метод main должен выводить данные на экран.
*/
public class Solution <T extends HashMap>{
    private T map;

    public Solution(T map) {
        this.map = map;
    }

    public HashMap getMap() {
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("string", 4);
        Solution solution = new Solution(hashMap);
        HashMap mapFromSolution = solution.getMap();
        System.out.println(mapFromSolution.getClass());


        LinkedHashMap<Solution, Solution> hashMap2 = new LinkedHashMap<>();
        hashMap2.put(solution, solution);
        Solution solution2 = new Solution(hashMap2);
        LinkedHashMap mapFromSolution2 = (LinkedHashMap)solution2.getMap();   //need to cast  :(
        System.out.println(mapFromSolution2.getClass());
    }
}
