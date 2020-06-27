package com.gb.amazonlocker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderPack {
    private String orderId;
    private List<Pack> lockerPacks;
}
