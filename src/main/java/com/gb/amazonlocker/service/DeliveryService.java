package com.gb.amazonlocker.service;

import com.gb.amazonlocker.exception.PackageSizeMappingException;
import com.gb.amazonlocker.model.*;
import com.gb.amazonlocker.repository.LockerPackageRepository;
import com.gb.amazonlocker.utils.IdGenerator;
import com.gb.amazonlocker.utils.SizeUtil;

import java.util.List;

public class DeliveryService {
    NotificationService notificationService = new NotificationService();
    OrderService orderService = new OrderService();
    LockerService lockerService = new LockerService();

    public void deliver(String orderId) throws PackageSizeMappingException {
        Order order = orderService.getOrder(orderId);
        List<Item> items = orderService.getItemsForOrder(orderId);
        Pack pack = new Pack(orderId, items);
        LockerSize lockerSize = SizeUtil.getLockerSizeForPack(pack.getPackageSize());
        Locker locker = lockerService.getLocker(lockerSize, order.getDeliveryGeoLocation());
        LockerPackage lockerPackage = new LockerPackage();
        lockerPackage.setOrderId(orderId);
        lockerPackage.setLockerId(locker.getId());
        lockerPackage.setCode(IdGenerator.generateId(6));
        LockerPackageRepository.lockerPackages.add(lockerPackage);
        locker.setLockerStatus(LockerStatus.CLOSED);
        notificationService.notifyCustomerOrder(lockerPackage);
    }
}
