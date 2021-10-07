package com.whitecloak.couplingsample.loosecoupling;

public class Car implements Vehicle{

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String startJourney() {
        return this.name + " is moving..";
    }
}
