package com.gb.amazonlocker.repository;

import com.gb.amazonlocker.TestData;
import com.gb.amazonlocker.model.LockerLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LockerLocationRepositoryTest {
    @BeforeAll
    public static void setup() {
        LockerLocationRepository.lockerLocations.add(
                TestData.setupLockerLocation("RMBGBGKAIN",
                        12.876416, 77.595466));
        LockerLocationRepository.lockerLocations.add(
                TestData.setupLockerLocation("VMBGBGKAIN",
                        12.909953, 77.601866));
    }

    @Test
    public void getLockerByLockerIdTest() {
        LockerLocation lockerLocation = LockerLocationRepository.getLockerLocation("RMBGBGKAIN");
        Assertions.assertNotNull(lockerLocation);
    }
}
