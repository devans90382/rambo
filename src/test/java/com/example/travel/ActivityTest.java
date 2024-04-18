package com.example.travel;

import com.example.exception.TravelServiceException;
import com.example.model.Activity;
import com.example.model.Destination;
import com.example.model.StandardPassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ActivityTest {

    private Activity activity;

    @BeforeEach
    public void init() {
        Destination paris = new Destination("Paris", new ArrayList<>());
        activity = new Activity("Honeymoon", "Romantic getaway", 100.0, 5, paris, new ArrayList<>());
    }

    @Test
    public void testActivityAvailability() {
        assertTrue(activity.isAvailable()); // Initial availability is true

        for (int i = 0; i < 5; i++) {
            activity.enrollPassenger(new StandardPassenger("Passenger " + i, i, 100.0));
        }

        assertFalse(activity.isAvailable()); // Availability should be false after reaching capacity
    }

    @Test
    public void testEnrollPassengerCapacityExceeded() {
        for (int i = 0; i < 5; i++) {
            activity.enrollPassenger(new StandardPassenger("Passenger " + i, i, 100.0));
        }
        StandardPassenger passenger = new StandardPassenger("Timepass Dost", 6, 100.0);
        assertThrows(TravelServiceException.class, () -> activity.enrollPassenger(passenger)); // Enrollment should fail due to capacity
    }
}
