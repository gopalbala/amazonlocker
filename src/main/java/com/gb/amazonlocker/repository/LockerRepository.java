package com.gb.amazonlocker.repository;

import com.gb.amazonlocker.model.Locker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockerRepository {
    public static List<Locker> lockers = new ArrayList<>();
    public static Map<String, Locker> lockerMap = new HashMap<>();
}
