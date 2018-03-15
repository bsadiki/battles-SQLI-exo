package com.nespresso.sofa.recruitment.navalbattles.team;

import com.nespresso.sofa.recruitment.navalbattles.ship.AttackingStrategy;
import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

import java.util.Iterator;
import java.util.List;

public class Team {
    List<Ship> ships;

    public Team(List<Ship> ships) {
        this.ships = ships;
    }

    public Double attack(Double bonus, AttackingStrategy attackingStrategy) {
        double attack = 0;
        for (Ship ship : this.ships) {
            if (!ship.sank())
                attack += ship.attack(attackingStrategy);
        }
        Double attackPlusBonus = attack + attack * bonus;
        return attackPlusBonus;
    }

    public void takeDamage(Double damage) {
        Iterator<Ship> shipsIterator = this.ships.listIterator();
        while (shipsIterator.hasNext()) {
            Ship ship = shipsIterator.next();
            if (!ship.sank()) {
                ship.takeDamage(damage);
                break;
            }
        }
    }

    public int numberOfShips() {
        int numberOfActiveShips = 0;
        for (Ship ship : this.ships) {
            if (!ship.sank())
                numberOfActiveShips++;
        }
        return numberOfActiveShips;
    }

    public boolean contains(Ship ship) {
        return this.ships.contains(ship);
    }

    public boolean stillInCombat() {
        for (Ship ship : this.ships) {
            if (!ship.sank())
                return true;
        }
        return false;
    }
}
