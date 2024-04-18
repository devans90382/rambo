package com.example.model;

import com.example.exception.ErrorCodes;
import com.example.exception.TravelServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> passengers;

    /**
     * Enroll a passenger for the activity.
     */
    public void enrollPassenger(Passenger passenger) {
        if (isAvailable()) {
            passengers.add(passenger);
        } else {
            throw new TravelServiceException(ErrorCodes.SEATS_CAPACITY_EXCEEDED, ErrorCodes.SEATS_CAPACITY_EXCEEDED.getDescription());
        }
    }

    /**
     * Check if the activity has available slots.
     */
    public boolean isAvailable() {
        return passengers.size() < capacity;
    }
}
