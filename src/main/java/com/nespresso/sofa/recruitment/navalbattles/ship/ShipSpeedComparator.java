package com.nespresso.sofa.recruitment.navalbattles.ship;

import java.util.Comparator;

public class ShipSpeedComparator implements Comparator<Ship> {
    @Override
    public int compare(Ship ship1, Ship ship2) {
        return Double.compare(ship1.speed(),ship2.speed());
    }
}
