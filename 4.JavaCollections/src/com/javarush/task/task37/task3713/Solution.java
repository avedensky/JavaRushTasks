package com.javarush.task.task37.task3713;

import com.javarush.task.task37.task3713.space.crew.AbstractCrewMember;
import com.javarush.task.task37.task3713.space.SpaceShip;

/* 
Chain of Responsibility

Амиго, у нас проблема! Во время визита на планету #IND893 мы рискнули отдать на аутсорсинг
автоматизацию входящих задач для членов команды. В это сложно поверить, но похоже всю работу
теперь должен выполнять первый помощник!

Необходимо срочно исправить поведение программы, ведь полы может помыть и юнга,
а приказ «к бою!» может дать только капитан.

P.S. Постарайся реализовать метод handleRequest таким образом, чтобы при добавлении
новых должностей нам не требовалось вносить в него изменения. Другие методы не трогай.

P.P.S. Все enum поддерживают интерфейс Comparable.


Требования:
1. Запрос должен быть обработан текущим членом команды, если это возможно.
2. Запрос должен быть передан по цепочке выше, если текущий член команды не может его обработать.
3. Классы CabinBoy, Engineer, FirstMate и Captain должны быть потомками класса AbstractCrewMember.
4. Класс AbstractCrewMember должен быть абстрактным.
*/
public class Solution {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        AbstractCrewMember crewMember = spaceShip.getCrewChain();

        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.EXPERT, "ATTACK");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.NOVICE, "WASH THE FLOOR");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.INTERMEDIATE, "CHECK ENGINE");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.ADVANCED, "SET ROUTE");
    }
}
