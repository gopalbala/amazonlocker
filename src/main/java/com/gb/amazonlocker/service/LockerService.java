package com.gb.amazonlocker.service;

import com.gb.amazonlocker.exception.LockeCodeMisMatchException;
import com.gb.amazonlocker.exception.LockerNotFoundException;
import com.gb.amazonlocker.exception.PackPickTimeExceededException;
import com.gb.amazonlocker.exception.PackageSizeMappingException;
import com.gb.amazonlocker.model.*;
import com.gb.amazonlocker.repository.LockerPackageRepository;
import com.gb.amazonlocker.repository.LockerRepository;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class LockerService {

    ProductService productService = new ProductService();
    LockerRepository lockerRepository = new LockerRepository();

    public GeoLocation findLockerIbyId(String id) {
        return LockerRepository.lockerMap.get(id).getLockerLocation().getGeoLocation();
    }

    public Locker getLocker(LockerSize lockerSize, GeoLocation geoLocation) {
        return getAvailableLocker(lockerSize, geoLocation);
    }

    private Locker getAvailableLocker(LockerSize lockerSize,
                                      GeoLocation geoLocation) {
        return checkAndGetAvailableLockers(lockerSize, geoLocation);
    }

    private Locker checkAndGetAvailableLockers(LockerSize lockerSize,
                                               GeoLocation geoLocation) {
        Locker locker = lockerRepository.getLocker(lockerSize, geoLocation);
        locker.setLockerStatus(LockerStatus.BOOKED);
        return locker;
    }

    public LockerSize getLockerSizeForPack(Pack pack) throws
            PackageSizeMappingException {
        double packSize = pack.getPackageSize();
        if (pack.getPackageSize() < 10) {
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
                    "the largest available locker.");
        }
    }

    public void pickupFromLocker(String lockerId,
                                 LocalDateTime localDateTime, String code) throws
            LockerNotFoundException, LockeCodeMisMatchException, PackPickTimeExceededException {
        Optional<LockerPackage> lockerPackage =
                LockerPackageRepository.getLockerByLockerId(lockerId);
        if (!lockerPackage.isPresent())
            throw new LockerNotFoundException("Locker with code not found");
        if (!lockerPackage.get().verifyCode(code))
            throw new LockeCodeMisMatchException("Locker code mismatch");
        Locker locker = LockerRepository.lockerMap.get(lockerId);
        if (canPickFromLocker(lockerId, localDateTime)) {
            locker.setLockerStatus(LockerStatus.AVAILALBE);
            lockerPackage.get().setCode(null);
        } else {
            lockerPackage.get().setCode(null);
            throw new PackPickTimeExceededException("Package not picked for x days");
        }
    }

    private boolean canPickFromLocker(String lockerId, LocalDateTime localDateTime) {
        Locker locker = LockerRepository.lockerMap.get(lockerId);
        LocationTiming locationTiming = locker.getLockerLocation().getLocationTiming();
        Timing timing = locationTiming.getTimingMap().get(localDateTime.getDayOfWeek());
        Time currentTime = Time.valueOf(getTimeFromDate(localDateTime));
        if (currentTime.after(timing.getOpenTime()) && currentTime.before(timing.getCloseTime())) {
            return true;
        }
        return false;
    }

    private String getTimeFromDate(LocalDateTime localDateTime) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        return time;
    }


}
