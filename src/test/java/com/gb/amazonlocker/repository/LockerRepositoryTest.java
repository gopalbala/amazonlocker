package com.gb.amazonlocker.repository;

import com.gb.amazonlocker.TestData;
import com.gb.amazonlocker.model.Locker;
import com.gb.amazonlocker.model.LockerLocation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerRepositoryTest {
    @BeforeAll
    public static void setup() {
        LockerLocation lockerLocation = TestData.setupLockerLocation("RMBGBGKAIN",
                12.876416, 77.595466);
        LockerRepository.lockers.addAll(lockerLocation.getLockers());
        for (Locker locker : LockerRepository.lockers) {
            LockerRepository.lockerMap.put(locker.getId(), locker);
        }
    }

    @Test
    public void shouldFetchLocker() {
        Locker locker = LockerRepository.lockerMap.get(LockerRepository.lockers.get(0).getId());
        assertNotNull(locker);
    }
}
