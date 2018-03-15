package com.nespresso.sofa.recruitment.navalbattles.ship;

public class Mast {
    private double hitPoints;

    public Mast() {
        this.hitPoints = 1000;
    }

    Double hitPoints() {
        return this.hitPoints;
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
