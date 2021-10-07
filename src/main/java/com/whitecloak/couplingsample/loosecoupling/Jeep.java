package com.whitecloak.couplingsample.loosecoupling;

public class Jeep implements Vehicle {

    private String name;

    public Jeep(String name) {
        this.name = name;
    }

    @Override
    public String startJourney() {
        return this.name + " is moving..";
    }
}
