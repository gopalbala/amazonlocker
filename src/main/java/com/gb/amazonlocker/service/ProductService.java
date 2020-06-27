package com.gb.amazonlocker.service;

public class ProductService {
    public double getProductVolume(String productId) {
        double[] volumes = new double[]{10, 20, 40, 50, 70, 90};
        int vol = (int) Math.random() * volumes.length;
        return volumes[vol];
    }
}
