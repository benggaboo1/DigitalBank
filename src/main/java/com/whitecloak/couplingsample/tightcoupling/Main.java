package com.whitecloak.couplingsample.tightcoupling;

public class Main {

    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        traveler.setCar(new Car("Corolla"));
        traveler.startJourney();
    }
}
