package com.nespresso.sofa.recruitment.navalbattles;

import com.nespresso.sofa.recruitment.navalbattles.ship.AttackingStrategy;
import com.nespresso.sofa.recruitment.navalbattles.ship.GlobalAttackingStrategy;
import com.nespresso.sofa.recruitment.navalbattles.ship.LocalizedAttackingStrategy;
import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;
import com.nespresso.sofa.recruitment.navalbattles.team.Team;

import java.util.Arrays;
import java.util.List;

public class Battle {
    private Team team1;
    private Team team2;
    private Team winningTeam;
    static boolean LOCALIZED_DAMAGES = true;
    private AttackingStrategy attackingStrategy;

    Battle(boolean localizedDamages) {
        attackingStrategy = new LocalizedAttackingStrategy();
    }

    Battle() {
        attackingStrategy = new GlobalAttackingStrategy();
    }

    public Battle side(Ship... ships) {
        List<Ship> shipList = Arrays.asList(ships);
        this.team1 = new Team(shipList);
        return this;
    }

    public Battle against(Ship... ships) {
        List<Ship> shipList = Arrays.asList(ships);
        this.team2 = new Team(shipList);
        fight();
        return this;
    }

    private void fight() {
        while (this.team1.stillInCombat() && this.team2.stillInCombat()) {
            Double attack = attack(team1, Math.max((team1.numberOfShips() - team2.numberOfShips()), 0));
            Double counterAttack = attack(team2, Math.max((team2.numberOfShips() - team2.numberOfShips()), 0));
            takeDamage(this.team2, attack);
            takeDamage(this.team1, counterAttack);
        }
        if (this.team1.stillInCombat())
            this.winningTeam = team1;
        else if (this.team2.stillInCombat())
            this.winningTeam = team2;
    }

    private Double attack(Team attackingTeam, int numberDifference) {
        Double bonus = numberDifference * .15;
        return attackingTeam.attack(bonus, this.attackingStrategy);
    }

    private void takeDamage(Team defendingTeam, Double damage) {
        defendingTeam.takeDamage(damage);
    }

    public boolean isInTheWinningSide(Ship ship) {
        return this.winningTeam.contains(ship);
    }
}
