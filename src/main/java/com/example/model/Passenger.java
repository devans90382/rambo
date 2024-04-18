package com.example.model;

import com.example.exception.ErrorCodes;
import com.example.exception.TravelServiceException;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Passenger {

    public enum PassengerType {
        STANDARD, GOLD, PREMIUM
    }

    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType type;
    private List<Activity> activities = new ArrayList<>();

    public Passenger(String name, int passengerNumber, double balance, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.type = type;
    }

    /**
     * Sign up for an activity.
     */
    public void signUpForActivity(Activity activity) {
        if (deductCost(activity.getCost())) {
            activities.add(activity);
            activity.enrollPassenger(this);
        } else {
            throw new TravelServiceException(ErrorCodes.INSUFFICIENT_BALANCE, ErrorCodes.INSUFFICIENT_BALANCE.getDescription());
        }
    }

    /**
     * Deduct cost from passenger's balance based on passenger type for an activity
     */
    public abstract boolean deductCost(double cost);

    public void printDetails() {
        System.out.println("Passenger Name: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Balance: " + balance);
        for (Activity activity : activities) {
            double pricePaid = type == PassengerType.GOLD ? activity.getCost() * 0.9 : activity.getCost();
            System.out.println("  Activity: " + activity.getName() + ", Destination: " +
                    activity.getDestination().getName() + ", Price Paid: " + (type == PassengerType.PREMIUM ? 0 : pricePaid));
        }
    }
}
