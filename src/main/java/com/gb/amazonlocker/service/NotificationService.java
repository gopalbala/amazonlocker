package com.gb.amazonlocker.service;

import com.gb.amazonlocker.model.LockerPackage;
import org.apache.commons.lang3.RandomStringUtils;

public class NotificationService {
    CustomerService customerService = new CustomerService();

    public void notifyCustomerOrder(LockerPackage lockerPackage) {

        String customerId = customerService.getCustomerIdForOrder(lockerPackage.getOrderId());
        System.out.printf("Customer %s notified for order %s " +
                        " in locker %s with pin %s", customerId,
                lockerPackage.getOrderId(),
                lockerPackage.getLockerId(),
                RandomStringUtils.randomAlphanumeric(6));
        System.out.println();
    }
}
