package com.gb.amazonlocker.service;

import com.gb.amazonlocker.model.Item;
import com.gb.amazonlocker.model.Locker;
import com.gb.amazonlocker.model.LockerStatus;

public class ReturnsService {

    public void returnItemsToLocker(Item item, Locker locker) {
        locker.setLockerStatus(LockerStatus.CLOSED);
    }

}
