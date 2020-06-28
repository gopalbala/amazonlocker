package com.gb.amazonlocker.service;

import com.gb.amazonlocker.model.LockerPackage;
import com.gb.amazonlocker.model.Notification;
import com.gb.amazonlocker.repository.NotificationRepository;
import org.apache.commons.lang3.RandomStringUtils;

public class NotificationService {
    CustomerService customerService = new CustomerService();

    public void notifyCustomerOrder(LockerPackage lockerPackage) {
        String customerId = customerService.getCustomerIdForOrder(lockerPackage.getOrderId());
        Notification notification = new Notification(customerId, lockerPackage.getOrderId(),
                lockerPackage.getLockerId(), RandomStringUtils.randomAlphanumeric(6));
        NotificationRepository.notificationMap.put(lockerPackage.getOrderId(), notification);
        System.out.printf("Customer %s notified for order %s " +
                        " in locker %s with pin %s", customerId,
                lockerPackage.getOrderId(),
                lockerPackage.getLockerId(),
                lockerPackage.getCode()
        );

    }
}
