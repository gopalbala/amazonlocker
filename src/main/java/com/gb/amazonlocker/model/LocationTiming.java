package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class LocationTiming {
    private Map<DayOfWeek, Timing> timingMap = new HashMap<>();
}
