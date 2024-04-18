package com.example.model;

public class GoldPassenger extends Passenger {

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance, PassengerType.GOLD);
    }

    @Override
    public boolean deductCost(double cost) {
        double discountedCost = cost * 0.90;
        if (getBalance() >= discountedCost) {
            setBalance(getBalance() - discountedCost);
            return true;
        }
        return false;
    }
}
