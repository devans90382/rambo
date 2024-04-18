package com.example.model;

import com.example.exception.ErrorCodes;
import com.example.exception.TravelServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Package {
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    /**
     * Add a destination to the travel package.
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Add a passenger to the travel package.
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            throw new TravelServiceException(ErrorCodes.SEATS_CAPACITY_EXCEEDED, ErrorCodes.SEATS_CAPACITY_EXCEEDED.getDescription());
        }
    }

    /**
     * Print the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Print the passenger list of the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Print details of activities with available spaces.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if (activity.isAvailable()) {
                    System.out.println("Activity: " + activity.getName() + ", Spaces Left: " +
                            (activity.getCapacity() - activity.getPassengers().size()));
                }
            }
        }
    }
}
