package com.gb.amazonlocker.service;

import com.gb.amazonlocker.model.*;

import java.util.List;

public class DeliveryService {
    NotificationService notificationService = new NotificationService();
    OrderService orderService = new OrderService();
    LockerService lockerService = new LockerService();

    public void deliver(String orderId) {
        Order order = orderService.getOrder(orderId);
        List<Item> items = orderService.getItemsForOrder(orderId);
        Pack pack = new Pack(orderId, items);
        LockerSize lockerSize = lockerService.getLockerSizeForPack(pack);
        Locker locker = lockerService.getLocker(lockerSize, order.getDeliveryLocation());
        locker.setLockerStatus(LockerStatus.CLOSED);
        notificationService.notifyCustomerOrder(orderId, locker.getId());
    }
}
