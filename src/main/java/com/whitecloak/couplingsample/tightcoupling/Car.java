package com.whitecloak.couplingsample.tightcoupling;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String move() {
        return this.name + " is moving..";
    }
}
