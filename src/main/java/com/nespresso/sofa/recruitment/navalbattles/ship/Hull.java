package com.nespresso.sofa.recruitment.navalbattles.ship;

public class Hull {
    int displacement;
    private double hitPoints;

    public Hull(int displacement) {
        this.hitPoints = displacement;
        this.displacement = displacement;
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
