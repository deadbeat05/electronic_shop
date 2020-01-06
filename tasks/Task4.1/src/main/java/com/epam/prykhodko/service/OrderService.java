package com.epam.prykhodko.service;

import com.epam.prykhodko.repository.OrderRepository;
import com.epam.prykhodko.task1.entity.Product;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class OrderService {

  private OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public void add(Date time, Map<Product, Integer> basket) {
    orderRepository.add(time, basket);
  }

  public TreeMap<Date, Map<Product, Integer>> get(){
    return orderRepository.get();
  }

}