package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LockerLocation {
    private String locationId;
    private List<Locker> lockers = new ArrayList<>();
    private GeoLocation geoLocation;
    private LocationTiming locationTiming;
}
