package com.nespresso.sofa.recruitment.navalbattles.ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ship {
    private Hull hull;
    private List<Mast> masts;
    List<Canon> cannons;
    private Double hitPoints;
    public Ship(int displacement, int mast) {
        this.hull = new Hull(displacement);
        this.masts = new ArrayList<>();
        for (int i = 0; i < mast; i++)
            this.masts.add(new Mast());
        this.cannons = new ArrayList<>();
        calculateHitPoints();
    }


    public Ship(int displacement, int mast, int cannons) {
        this.hull = new Hull(displacement);
        this.masts = new ArrayList<>();
        for (int i = 0; i < mast; i++)
            this.masts.add(new Mast());
        this.cannons = new ArrayList<>();
        for (int i = 0; i < cannons; i++)
            this.cannons.add(new Canon());
        calculateHitPoints();
    }

    double speed() {
        double speed = ((double) hull.displacement);
        if (masts != null && !masts.isEmpty()) {
            speed = speed / masts.size();
        }
        if (this.cannons != null) {
            speed = speed * 0.005 * this.cannons.size() + speed;
        }
        return speed;
    }

    public double attack(AttackingStrategy attackingStrategy) {
        return attackingStrategy.attack(this);
    }

    public Double takeDamage(Double damage) {
        damage = mastsTakeDamage(damage);
        if (damage > 0)
            damage = canonsTakeDamage(damage);
        if (damage > 0)
            damage = hullTakeDamage(damage);
        calculateHitPoints();
        return damage;
    }

    private Double mastsTakeDamage(Double damage) {
        Iterator<Mast> mastIterator = this.masts.listIterator();
        while (mastIterator.hasNext() && damage > 0) {
            Mast mast = mastIterator.next();
            if (!mast.isDestroyed())
                damage = mast.takeDamage(damage);
        }
        return damage;
    }

    private Double canonsTakeDamage(Double damage) {
        Iterator<Canon> canonIterator = this.cannons.listIterator();
        while (canonIterator.hasNext() && damage > 0) {
            Canon canon = canonIterator.next();
            if (!canon.isDestroyed())
                damage = canon.takeDamage(damage);
        }
        return damage;
    }

    private Double hullTakeDamage(Double damage) {
        if (!this.hull.isDestroyed())
            damage = this.hull.takeDamage(damage);
        return damage;
    }

    public boolean sank() {
        return (this.hitPoints <= 0);
    }

    private void calculateHitPoints() {
        double hullHitPoints = this.hull.hitPoints();
        double mastHitPoints = 0;
        for (Mast mast : this.masts) {
            mastHitPoints += mast.hitPoints();
        }
        double cannonsHitPoints = 0;
        for (Canon canon : this.cannons) {
            cannonsHitPoints += canon.hitPoints();
        }
        this.hitPoints = hullHitPoints + mastHitPoints + cannonsHitPoints;
    }

}