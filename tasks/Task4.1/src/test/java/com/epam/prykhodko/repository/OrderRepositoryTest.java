package com.epam.prykhodko.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.prykhodko.task1.entity.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {

  @Test
  void addSizeShouldBeEqualOne() {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    OrderRepository repository = new OrderRepository();
    Map<Product, Integer> map = new TreeMap<>();
    map.put(new Product(), 4);
    try {
      repository.add(format.parse("20/02/2020 20:20"), map);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int expected = 1;
    int actual = repository.get().size();
    assertEquals(expected,actual);
  }

  @Test
  void get() {
    assertNotNull(new OrderRepository().get());
  }
}