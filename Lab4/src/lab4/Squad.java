/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Алексей
 */

public class Squad implements Cloneable {

    private String squadName;
    private ArrayList<Warrior> warriors;

    public Squad(String squadName, Warrior[] warriorsAll) {
        this.squadName = squadName;
        this.warriors = new ArrayList<>();
        for (Warrior warrior : warriorsAll) {
            if (warrior.getSquadName().equals(squadName)) {
                warriors.add(warrior);
            }
        }
    }

    public Warrior getRandomWarrior() {
        if (!hasAliveWarriors()) {//если уже нет живых
            return null;
        }
        Random r = new Random();
        int randI = r.nextInt(warriors.size());
        while (!warriors.get(randI).isAlive()) {//пока рандом не найдет живого игрока
            randI = r.nextInt(warriors.size());
        }
        return warriors.get(randI);
    }

    public boolean hasAliveWarriors() {
        for (Warrior warrior : warriors) {
            if (warrior.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public Squad clone() throws CloneNotSupportedException {
        Squad ob = (Squad) super.clone();
        ob.squadName = squadName;
        ob.warriors = new ArrayList();
        for (Warrior warrior : warriors) {
            ob.warriors.add(((Fighter) warrior).clone());
        }
        return ob;
    }

    @Override
    public String toString() {
        return squadName;
    }

    public ArrayList<Warrior> getWarriors() {
        return warriors;
    }

    public int getWarriorsCount() {
        return warriors.size();
    }
}
