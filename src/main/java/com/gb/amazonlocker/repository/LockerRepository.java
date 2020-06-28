package com.gb.amazonlocker.repository;

import com.gb.amazonlocker.model.GeoLocation;
import com.gb.amazonlocker.model.Locker;
import com.gb.amazonlocker.model.LockerSize;
import com.gb.amazonlocker.model.LockerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LockerRepository {
    public static List<Locker> lockers = new ArrayList<>();
    public static Map<String, Locker> lockerMap = new HashMap<>();

    public Locker getLocker(LockerSize lockerSize, GeoLocation location) {
        List<Locker> lockers =
                this.lockers.stream()
                        .filter(locker -> locker.getLockerStatus() == LockerStatus.AVAILALBE)
                        .collect(Collectors.toList());
        if (lockers != null && lockers.size() > 0)
            return lockers.get(0);
        return null;
    }
}
