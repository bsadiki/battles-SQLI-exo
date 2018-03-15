package com.nespresso.sofa.recruitment.navalbattles.ship;

public class Canon {
    private double hitPoints;
    private double power;

    public Canon() {
        this.hitPoints = 100;
        this.power = 200;
    }

    Double hitPoints() {
        return this.hitPoints;
    }

    public double attack() {
        //    if (!isDestroyed())
        return this.power;
        //  return 0;
    }

    Double takeDamage(Double damage) {
        Double RemainingDamage = damage - this.hitPoints;
        this.hitPoints = Math.max(0, this.hitPoints - damage);
        return Math.max(0, RemainingDamage);
    }

    boolean isDestroyed() {
        return (this.hitPoints == 0);
    }
}
