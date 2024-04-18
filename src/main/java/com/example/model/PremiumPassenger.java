package com.example.model;

public class PremiumPassenger extends Passenger {

    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0, PassengerType.PREMIUM);
    }

    @Override
    public boolean deductCost(double cost) {
        return true; // Premium passengers don't have to pay
    }
}
