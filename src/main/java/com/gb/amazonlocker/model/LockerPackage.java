package com.gb.amazonlocker.model;

import com.gb.amazonlocker.exception.PickupCodeExpiredException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LockerPackage {
    final int codeValidDays = 3;
    private String lockerId;
    private String orderId;
    private String code;
    private LocalDateTime packageDeliveredTime;

    public boolean isValidCode(LocalDateTime currentTime) throws PickupCodeExpiredException {
        if (currentTime.compareTo(packageDeliveredTime) > 3) {
            throw new PickupCodeExpiredException("Pickup code expired.");
        }
        return true;
    }

    public boolean verifyCode(String code) {
        return this.code.equals(code);
    }
}
