package com.nespresso.sofa.recruitment.navalbattles;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;
import com.nespresso.sofa.recruitment.navalbattles.ship.ShipSpeedComparator;

import java.util.Arrays;
import java.util.List;

public class Race {
    Ship winnerShip;
    public Race(Ship... ships) {
        List<Ship> shipList = Arrays.asList(ships);
        ShipSpeedComparator shipSpeedComparator = new ShipSpeedComparator();
        shipList.sort(shipSpeedComparator);
        this.winnerShip = shipList.get(0);
    }

    public Ship winner() {
        return this.winnerShip;
    }
}
