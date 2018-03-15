package com.nespresso.sofa.recruitment.navalbattles.ship;

public class Clipper extends Ship {
    public Clipper(int displacement, int mast) {
        super(displacement, mast);
    }

    @Override
    double speed() {
        double normalSpeed= super.speed();
        double realSpeed = normalSpeed - normalSpeed*.2;
        return realSpeed;
    }
}
