package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@Setter
public class Locker {
    private String id;
    private LockerSize lockerSize;
    private GeoLocation geoLocation;
    private LockerStatus lockerStatus;
    private String allotedCustomerId;

    public Locker() {
        id = RandomStringUtils.randomAlphanumeric(8);
    }

}
