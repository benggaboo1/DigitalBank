package com.whitecloak.couplingsample.loosecoupling;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car("Corolla");
        Traveler traveler = new Traveler(car);
        traveler.startJourney();

        Vehicle jeep = new Jeep("Jeep ni manong");
        traveler.setVehicle(jeep);
        traveler.startJourney();

    }
}
