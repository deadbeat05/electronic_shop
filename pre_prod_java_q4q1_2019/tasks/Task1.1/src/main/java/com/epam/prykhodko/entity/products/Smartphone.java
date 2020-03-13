package com.epam.prykhodko.entity.products;

import com.epam.prykhodko.annotation.Description;
import java.math.BigDecimal;
import java.util.Objects;

public class Smartphone extends Telephone {

  @Description(title = "model_of_touchscreen")
  private String modelOfTouchScreen;

  public Smartphone() {
  }

  public Smartphone(Telephone telephone) {
    super(telephone);
    this.setCommunicationStandard(telephone.getCommunicationStandard());
  }

  public Smartphone(int id, BigDecimal price, String manufacturer, String communicationStandard,
      String modelOfTouchScreen) {
    super(id, price, manufacturer, communicationStandard);
    this.modelOfTouchScreen = modelOfTouchScreen;
  }

  public String getModelOfTouchScreen() {
    return modelOfTouchScreen;
  }

  public void setModelOfTouchScreen(String modelOfTouchScreen) {
    this.modelOfTouchScreen = modelOfTouchScreen;
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Smartphone that = (Smartphone) o;
    return Objects.equals(modelOfTouchScreen, that.modelOfTouchScreen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), modelOfTouchScreen);
  }

  @Override
  public String toString() {
    return super.toString() + "modelOfTouchScreen='" + modelOfTouchScreen + '\'';
  }
}