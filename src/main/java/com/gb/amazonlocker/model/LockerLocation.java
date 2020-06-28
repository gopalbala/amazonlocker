package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LockerLocation {
    List<Locker> lockers;
    private GeoLocation geoLocation;
    private LocationTiming locationTiming;
}
