package com.gb.amazonlocker.repository;

import com.gb.amazonlocker.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderRepositoryTest {
    @BeforeAll
    public static void setup() {
        OrderRepository.orderMap.put("o1", TestData.getPhoneOrder());
        OrderRepository.orderMap.put("o2", TestData.getHeadSetOrder());
    }

    @Test
    public void shouldGetOrderById() {
        assertNotNull(OrderRepository.getOrder("o1"));
        assertNotNull(OrderRepository.getOrder("o2"));
    }
}
