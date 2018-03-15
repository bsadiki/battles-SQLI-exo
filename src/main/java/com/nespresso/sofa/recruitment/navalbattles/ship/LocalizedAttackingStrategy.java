package com.nespresso.sofa.recruitment.navalbattles.ship;

public class LocalizedAttackingStrategy implements AttackingStrategy {
    @Override
    public double attack(Ship ship) {
        double attack = 0;
        for (Canon canon : ship.cannons) {
            if (!canon.isDestroyed())
                attack += canon.attack();
        }
        return attack;
    }
}
