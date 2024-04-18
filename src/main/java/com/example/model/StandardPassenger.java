package com.example.model;

public class StandardPassenger extends Passenger {

    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance, PassengerType.STANDARD);
    }

    @Override
    public boolean deductCost(double cost) {
        if (getBalance() >= cost) {
            setBalance(getBalance() - cost);
            return true;
        }
        return false;
    }
}
