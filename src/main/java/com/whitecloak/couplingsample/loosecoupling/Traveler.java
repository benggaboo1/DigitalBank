package com.whitecloak.couplingsample.loosecoupling;

import org.springframework.beans.factory.annotation.Autowired;

public class Traveler {

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private Vehicle vehicle;

    @Autowired
    public Traveler(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney() {
        System.out.println(vehicle.startJourney());
    }
}
