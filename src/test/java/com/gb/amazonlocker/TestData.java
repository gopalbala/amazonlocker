package com.gb.amazonlocker;

import com.gb.amazonlocker.model.*;
import com.gb.amazonlocker.utils.IdGenerator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {

    public static Map<String, LockerLocation> lockerLocationMap = new HashMap<>();

    public static void setupTest() {
        setupLockerLocation("RMBGBGKAIN",
                12.876416, 77.595466);
        setupLockerLocation("VMBGBGKAIN",
                12.909953, 77.601866);
    }

    public static LockerLocation setupLockerLocation(String locationId,
                                                     double latitude, double longitude) {
        LockerLocation lockerLocation = getLockerLocation(locationId, latitude, longitude);
        for (int i = 0; i < 50; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.XS, locationId));
        }
        for (int i = 0; i < 50; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.S, locationId));
        }
        for (int i = 0; i < 40; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.M, locationId));
        }
        for (int i = 0; i < 30; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.L, locationId));
        }
        for (int i = 0; i < 20; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.XL, locationId));
        }
        for (int i = 0; i < 10; i++) {
            lockerLocation.getLockers().add(createLocker(LockerSize.XXL, locationId));
        }
        return lockerLocation;
    }

    public static Locker createLocker(LockerSize lockerSize, String locationId) {
        return new Locker(lockerSize, locationId);
    }

    public static LockerLocation getLockerLocation(String locationId,
                                                   double latitude,
                                                   double longitude) {
        LockerLocation lockerLocation = new LockerLocation();
        lockerLocation.setLocationId(locationId);
        LocationTiming locationTiming = new LocationTiming();
        locationTiming.setTimingMap(getTiming());
        lockerLocation.setLocationTiming(locationTiming);
        lockerLocation.setGeoLocation(new GeoLocation(latitude, longitude));
        return lockerLocation;
    }

    public static Map<DayOfWeek, Timing> getTiming() {
        Map<DayOfWeek, Timing> timingMap = new HashMap<>();

        timingMap.put(DayOfWeek.MONDAY, new Timing("9:00:00", "22:00:00"));
        timingMap.put(DayOfWeek.TUESDAY, new Timing("9:00:00", "22:00:00"));
        timingMap.put(DayOfWeek.WEDNESDAY, new Timing("9:00:00", "22:00:00"));
        timingMap.put(DayOfWeek.THURSDAY, new Timing("9:00:00", "22:00:00"));
        timingMap.put(DayOfWeek.FRIDAY, new Timing("9:00:00", "22:00:00"));
        timingMap.put(DayOfWeek.SATURDAY, new Timing("7:00:00", "23:00:00"));
        timingMap.put(DayOfWeek.SUNDAY, new Timing("7:00:00", "23:00:00"));
        return timingMap;
    }

    public static LockerPackage getLockerPackage() {
        LockerPackage lockerPackage = new LockerPackage();
        LockerLocation lockerLocation = setupLockerLocation("VMBGBGKAIN",
                12.909953, 77.601866);
        lockerPackage.setCode(IdGenerator.generateId(8));
        lockerPackage.setLockerId(lockerLocation.getLockers().get(0).getId());
        lockerPackage.setPackageDeliveredTime(LocalDateTime.now());
        lockerPackage.setOrderId(IdGenerator.generateId(12));
        lockerPackage.setCode(IdGenerator.generateId(6));
        return lockerPackage;
    }

    public static Order getPhoneOrder() {
        Order order = new Order();
        Item item = new Item();
        item.setId("IPHONE11");
        item.setQuantity(1);
        order.setOrderId(IdGenerator.generateId(16));
        order.setItems(List.of(item));
        order.setDeliveryGeoLocation(new GeoLocation(12.909953, 77.601866));
        return order;
    }

    public static Order getHeadSetOrder() {
        Order order = new Order();
        Item item = new Item();
        item.setId("JABRAWLHS");
        item.setQuantity(1);
        order.setOrderId(IdGenerator.generateId(16));
        order.setItems(List.of(item));
        order.setDeliveryGeoLocation(new GeoLocation(12.876416, 77.595466));
        return order;
    }

    public static Pack getPackage() {
        Order order = getPhoneOrder();
        Pack pack = new Pack(order.getOrderId(), order.getItems());
        return pack;
    }
}
