package com.epam.prykhodko.map;

import com.epam.prykhodko.entity.products.Notebook;
import com.epam.prykhodko.entity.products.Product;
import com.epam.prykhodko.entity.products.Telephone;
import com.epam.prykhodko.wrapper.HashCodeByLength;
import com.epam.prykhodko.wrapper.HashCodeBySumm;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Maps {

  private Telephone telephone;
  private Telephone telephone1;
  private Notebook notebook;
  private Notebook notebook1;

  public static void main(String[] args) {
    new Maps().mapsInit();
  }

  private void entityInit() {
    telephone = new Telephone();
    telephone1 = new Telephone();
    notebook = new Notebook();
    notebook1 = new Notebook();

    telephone.setId(1);
    telephone.setManufacturer("Apple");
    telephone.setPrice(new BigDecimal(999));
    telephone.setCommunicationStandard("4G");

    telephone1.setId(2);
    telephone1.setManufacturer("Samsung");
    telephone1.setPrice(new BigDecimal(1500));
    telephone1.setCommunicationStandard("5G");

    notebook.setId(3);
    notebook.setManufacturer("Asus");
    notebook.setPrice(new BigDecimal(1000));
    notebook.setModelOfTouchpad("asus");

    notebook1.setId(4);
    notebook1.setManufacturer("Hp");
    notebook1.setPrice(new BigDecimal(800));
    notebook1.setModelOfTouchpad("Hp");
  }

  public void mapsInit() {
    Map<HashCodeByLength, Product> hashMap = new HashMap();

    entityInit();

    hashMap.put(new HashCodeByLength(telephone.getManufacturer()), telephone);
    hashMap.put(new HashCodeByLength(telephone1.getManufacturer()), telephone1);
    hashMap.put(new HashCodeByLength(notebook.getManufacturer()), notebook);
    hashMap.put(new HashCodeByLength(notebook1.getManufacturer()), notebook1);

    Map<HashCodeBySumm, Product> linkedHashMap = new LinkedHashMap(16, 0.75f, true);

    linkedHashMap.put(new HashCodeBySumm(telephone.getManufacturer()), telephone);
    linkedHashMap.put(new HashCodeBySumm(telephone1.getManufacturer()), telephone1);
    linkedHashMap.put(new HashCodeBySumm(notebook.getManufacturer()), notebook);
    linkedHashMap.put(new HashCodeBySumm(notebook1.getManufacturer()), notebook1);

    linkedHashMap.get(telephone1);

    System.out.println(hashMap);

    for (HashCodeByLength key : hashMap.keySet()) {
      System.out.println(key);
    }
  }

}