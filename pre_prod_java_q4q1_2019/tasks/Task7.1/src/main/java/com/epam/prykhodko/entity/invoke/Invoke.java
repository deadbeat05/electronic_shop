package com.epam.prykhodko.entity.invoke;

import com.epam.prykhodko.entity.products.Product;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invoke implements InvocationHandler {

  private final Product product;

  public Invoke(Product product) {
    this.product = product;
  }

  @Override
  public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
    if (method.getName().startsWith("set")) {
      throw new UnsupportedOperationException();
    }
    return product.getClass().getMethod(method.getName()).invoke(product);
  }
}