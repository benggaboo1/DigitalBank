package com.whitecloak.couplingsample.tightcoupling;

import com.whitecloak.couplingsample.tightcoupling.Car;

public class Traveler {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void startJourney() {
        System.out.println(this.car.move());
    }
}
