package com.nespresso.sofa.recruitment.navalbattles.team;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

import java.util.Iterator;

public class NormalTeamDamageStrategy implements TeamDamageStrategy {
    @Override
    public void takeDamage(Team team, Double damage) {
        Iterator<Ship> shipsIterator = team.ships.listIterator();
        while (damage > 0 && shipsIterator.hasNext()) {
            Ship ship = shipsIterator.next();
            if (!ship.sank())
                damage = ship.takeDamage(damage);
        }
    }
}
