package com.gb.amazonlocker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private String orderId;
    private List<Item> items;
    private GeoLocation deliveryGeoLocation;
}
