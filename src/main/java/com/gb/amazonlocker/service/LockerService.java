package com.gb.amazonlocker.service;

import com.gb.amazonlocker.model.Location;
import com.gb.amazonlocker.model.Locker;
import com.gb.amazonlocker.model.LockerSize;

import java.util.*;

public class LockerService {

    ProductService productService = new ProductService();

    public List<Locker> getAvailableLockers(Location location, LockerSize lockerSize,
                                            int numberOfLockers) {
        return null;
    }

    private boolean checkAvailableLockers(Map<LockerSize, Integer> lockersRequired,
                                          Location location) {
        return Math.random() > 0.2;
    }

    public Map<LockerSize, Integer> getLockerCount(List<String> productIds) {
        List<Double> xs = new ArrayList<>();
        List<Double> s = new ArrayList<>();
        List<Double> m = new ArrayList<>();
        List<Double> l = new ArrayList<>();
        List<Double> xl = new ArrayList<>();
        List<Double> xxl = new ArrayList<>();

        ArrayList<Double> productSizes = new ArrayList<>();

        for (String productId : productIds) {
            //get the product bag volume
            // group them to sizes that fall under xs, s, m, l, xl
            // pass it to bin packing algorithm
            // get the number of lockers required for each size
            // put them in map and return
            productSizes.add(productService.getProductVolume(productId));

        }

        for (double productSize : productSizes) {
            if (productSize < 10) {
                xs.add(productSize);
            } else if (productSize > 10 && productSize <= 20) {
                s.add(productSize);
            } else if (productSize > 20 && productSize <= 40) {
                m.add(productSize);
            } else if (productSize > 40 && productSize <= 50) {
                l.add(productSize);
            } else if (productSize > 50 && productSize <= 70) {
                xl.add(productSize);
            } else {
                xxl.add(productSize);
            }
        }
        productSizes.sort(Collections.reverseOrder());

        Map<LockerSize, Integer> lockersRequired = new HashMap<>();
        if (xs.size() > 0) {
            lockersRequired.put(LockerSize.XS, getLargeLockerCount(xs));
        }
        if (s.size() > 0) {
            lockersRequired.put(LockerSize.S, getLargeLockerCount(s));
        }
        if (m.size() > 0) {
            lockersRequired.put(LockerSize.M, getLargeLockerCount(m));
        }
        if (l.size() > 0) {
            lockersRequired.put(LockerSize.L, getLargeLockerCount(l));
        }
        if (xl.size() > 0) {
            lockersRequired.put(LockerSize.XL, getLargeLockerCount(xl));
        }
        if (xxl.size() > 0) {
            lockersRequired.putIfAbsent(LockerSize.XXL, getXxLargeLockerCount(xxl));
        }
        return lockersRequired;
    }

    private int getXSmallLockerCount(List<Double> xSmallPackageSizes) {
        if (xSmallPackageSizes.size() == 0)
            return 0;
        if (xSmallPackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * xSmallPackageSizes.size();
    }

    private int getSmallLockerCount(List<Double> smallPackageSizes) {
        if (smallPackageSizes.size() == 0)
            return 0;
        if (smallPackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * smallPackageSizes.size();
    }

    private int getMediumLockerCount(List<Double> mediumPackageSizes) {
        if (mediumPackageSizes.size() == 0)
            return 0;
        if (mediumPackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * mediumPackageSizes.size();
    }

    private int getLargeLockerCount(List<Double> largePackageSizes) {
        if (largePackageSizes.size() == 0)
            return 0;
        if (largePackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * largePackageSizes.size();
    }

    private int getXLargeLockerCount(List<Double> sLargePackageSizes) {
        if (sLargePackageSizes.size() == 0)
            return 0;
        if (sLargePackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * sLargePackageSizes.size();
    }

    private int getXxLargeLockerCount(List<Double> sLargePackageSizes) {
        if (sLargePackageSizes.size() == 0)
            return 0;
        if (sLargePackageSizes.size() == 1)
            return 1;
        return (int) Math.random() * sLargePackageSizes.size();
    }

}
