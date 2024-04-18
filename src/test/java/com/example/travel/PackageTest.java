package com.example.travel;

import com.example.exception.TravelServiceException;
import com.example.model.Destination;
import com.example.model.Package;
import com.example.model.StandardPassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PackageTest {

    private Package travelPackage;

    @BeforeEach
    public void init() {
        travelPackage = new Package("Discover Europe", 10, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void testAddDestination() {
        Destination paris = new Destination("Paris", new ArrayList<>());
        travelPackage.addDestination(paris);
        travelPackage.printItinerary();
        assertTrue(travelPackage.getDestinations().contains(paris));
    }

    @Test
    public void testAddPassengerExceedsCapacity() {
        // Test - Within capacity will succeed
        for (int i = 0; i < 10; i++) {
            travelPackage.addPassenger(new StandardPassenger("Passenger " + i, i, 100.0));
        }

        //Test - Exceed capacity will throw exception
        assertThrows(TravelServiceException.class, () -> travelPackage.addPassenger(new StandardPassenger("Passenger " + 11, 11, 100.0)));
    }


}
