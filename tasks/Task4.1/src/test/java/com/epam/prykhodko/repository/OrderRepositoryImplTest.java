package com.epam.prykhodko.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.epam.prykhodko.repository.impl.OrderRepositoryImpl;
import com.epam.prykhodko.task1.entity.ProductRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class OrderRepositoryImplTest {

  @Test
  void addSizeShouldBeEqualOne() {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    OrderRepositoryImpl repository = new OrderRepositoryImpl();
    Map<ProductRepository, Integer> map = new TreeMap<>();
    map.put(new ProductRepository(), 4);
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
    assertNotNull(new OrderRepositoryImpl().get());
  }
}