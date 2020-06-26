package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locker {
    private String id;
    private LockerSize lockerSize;
    private Location location;
    private LockerStatus lockerStatus;
}
