package com.gb.amazonlocker.utils;

import com.gb.amazonlocker.exception.PackageSizeMappingException;
import com.gb.amazonlocker.model.LockerSize;

public class SizeUtil {
    public static LockerSize getLockerSizeForPack(double packSize) throws
            PackageSizeMappingException {
        if (packSize < 10) {
            return LockerSize.XS;
        } else if (packSize > 10 && packSize <= 20) {
            return LockerSize.S;
        } else if (packSize > 20 && packSize <= 40) {
            return LockerSize.M;
        } else if (packSize > 40 && packSize <= 50) {
            return LockerSize.L;
        } else if (packSize > 50 && packSize <= 70) {
            return LockerSize.XL;
        } else if (packSize > 70 && packSize <= 100) {
            return LockerSize.XXL;
        } else {
            throw new PackageSizeMappingException("Package size more than" +
                    " the largest available locker.");
        }
    }
}
