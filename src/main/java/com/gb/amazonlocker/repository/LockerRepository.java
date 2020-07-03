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
    public static List<Locker> lockers;
    public static Map<String, Locker> lockerMap;

    static {
        lockers = new ArrayList<>();
        lockerMap = new HashMap<>();
    }

    public static Locker getLocker(LockerSize lockerSize, GeoLocation location) {
        //assumption the near by locers in radius are fetched from a service

        List<Locker> lockerList =
                lockers.stream()
                        .filter(locker ->
                                locker.getLockerStatus() == LockerStatus.AVAILALBE &&
                                        locker.getLockerSize() == lockerSize)
                        .collect(Collectors.toList());
        if (lockerList != null && lockerList.size() > 0)
            return lockerList.get(0);
        return null;
    }
}
