package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@Setter
public class Locker {
    private String id;
    private LockerSize lockerSize;
    private LockerLocation lockerLocation;
    private LockerStatus lockerStatus;

    public Locker(LockerSize lockerSize, LockerLocation lockerLocation) {
        id = RandomStringUtils.randomAlphanumeric(8);
        this.lockerLocation = lockerLocation;
        this.lockerLocation = lockerLocation;
    }

}
