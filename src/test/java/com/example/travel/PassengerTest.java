package com.example.travel;

import com.example.exception.TravelServiceException;
import com.example.model.Activity;
import com.example.model.Destination;
import com.example.model.GoldPassenger;
import com.example.model.Passenger;
import com.example.model.PremiumPassenger;
import com.example.model.StandardPassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PassengerTest {

    private Activity activity;


    @BeforeEach
    public void init() {
        Destination paris = new Destination("Paris", new ArrayList<>());
        activity = new Activity("Honeymoon", "Romantic getaway", 100.0, 5, paris, new ArrayList<>());
    }

    @Test
    public void testStandardPassengerSignupForActivity() {
        Passenger passenger = new StandardPassenger("Kundan", 1, 200.0);
        passenger.signUpForActivity(activity);

        assertEquals(100.0, passenger.getBalance(), 0);
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testGoldPassengerSignupForActivity() {
        Passenger passenger = new GoldPassenger("Zoya", 2, 200.0);

        passenger.signUpForActivity(activity);

        assertEquals(110.0, passenger.getBalance(), 0); // 10% discount applied
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testPremiumPassengerSignupForActivity() {
        Passenger passenger = new PremiumPassenger("Bholenath", 3);

        passenger.signUpForActivity(activity);

        assertEquals(0.0, passenger.getBalance(), 0); // No cost for premium passenger
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testInsufficientBalance() {
        StandardPassenger passenger = new StandardPassenger("Akram", 1, 40.0); // Insufficient balance
        assertThrows(TravelServiceException.class, () -> passenger.signUpForActivity(activity)); // Signup should fail due to insufficient balance
    }
}