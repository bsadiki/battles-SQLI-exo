package com.nespresso.sofa.recruitment.navalbattles;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public abstract class TakingDammageStrategy {
    abstract Double takeDamage(Ship ship, Double damage);
}
