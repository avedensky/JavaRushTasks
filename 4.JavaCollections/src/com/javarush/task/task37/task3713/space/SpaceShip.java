package com.javarush.task.task37.task3713.space;

import com.javarush.task.task37.task3713.space.crew.*;

public class SpaceShip {
    public AbstractCrewMember getCrewChain(){
        AbstractCrewMember cabinBoy = new CabinBoy(AbstractCrewMember.CompetencyLevel.NOVICE);
        AbstractCrewMember engineer = new Engineer(AbstractCrewMember.CompetencyLevel.INTERMEDIATE);
        AbstractCrewMember firstMate = new FirstMate(AbstractCrewMember.CompetencyLevel.ADVANCED);
        AbstractCrewMember captain = new Captain(AbstractCrewMember.CompetencyLevel.EXPERT);

        cabinBoy.setNextCrewMember(engineer);
        engineer.setNextCrewMember(firstMate);
        firstMate.setNextCrewMember(captain);

        return cabinBoy;
    }
}
