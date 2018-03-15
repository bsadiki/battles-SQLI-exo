package com.nespresso.sofa.recruitment.navalbattles.ship;

public class GlobalAttackingStrategy implements AttackingStrategy {
    @Override
    public double attack(Ship ship) {
        double attack = 0;
        for (Canon canon : ship.cannons) {
                attack += canon.attack();
        }
        return attack;
    }
}
