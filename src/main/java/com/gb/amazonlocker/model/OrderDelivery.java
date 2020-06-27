package com.gb.amazonlocker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDelivery {
    private String orderId;
    private List<LockerPack> lockerPacks;
}
