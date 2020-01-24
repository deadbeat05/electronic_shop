package com.epam.prykhodko.task1.entity;

import com.epam.prykhodko.task1.annotation.Description;
import java.math.BigDecimal;
import java.util.Objects;

public class Notebook extends Product {

  @Description(title = "model_of_touchpad")
  private String modelOfTouchpad;

  public Notebook() {
  }

  public Notebook(Product product) {
    super(product);
  }

  public Notebook(int id, BigDecimal price, String manufacturer, String modelOfTouchpad) {
    super(id, price, manufacturer);
    this.modelOfTouchpad = modelOfTouchpad;
  }

  public String getModelOfTouchpad() {
    return modelOfTouchpad;
  }

  public void setModelOfTouchpad(String modelOfTouchpad) {
    this.modelOfTouchpad = modelOfTouchpad;
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Notebook notebook = (Notebook) o;
    return Objects.equals(modelOfTouchpad, notebook.modelOfTouchpad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelOfTouchpad);
  }

  @Override
  public String toString() {
    return super.toString() + "modelOfTouchpad='" + modelOfTouchpad + '\'';
  }
}
