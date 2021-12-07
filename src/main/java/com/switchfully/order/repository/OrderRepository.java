package com.switchfully.order.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderRepository {
    private HashMap<String, String> orders = new HashMap<>();


}
