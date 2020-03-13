package com.epam.prykhodko.creator;

import static com.epam.prykhodko.constant.Constants.INCORRECT_INPUT;

import com.epam.prykhodko.entity.input.InputType;
import com.epam.prykhodko.entity.products.Product;
import com.epam.prykhodko.entity.products.Smartphone;
import com.epam.prykhodko.entity.products.Telephone;
import com.epam.prykhodko.util.readers.ConsoleHelper;
import java.io.IOException;
import org.apache.log4j.Logger;

public class SmartphoneCreator extends ProductCreator {

  private static final Logger LOGGER = Logger.getLogger(ProductCreator.class);
  private boolean correctInputFlag;

  public SmartphoneCreator(InputType inputType) {
    super(inputType);
  }

  @Override
  public Product create() {
    final Smartphone smartphone =  new Smartphone((Telephone) super.create());
    setParameters(smartphone);
    return smartphone;
  }

  private void setParameters(Smartphone smartphone) {
    while (!correctInputFlag) {
      try {
        System.out.println("Enter model of touchscreen: ");
        String touchscreen = ConsoleHelper.readLine();
        smartphone.setModelOfTouchScreen(inputType.readLine(touchscreen));
        System.out.println("Enter communication standard");
        String communication = ConsoleHelper.readLine();
        smartphone.setCommunicationStandard(inputType.readLine(communication));
        correctInputFlag = true;
      } catch (IOException | NumberFormatException e) {
        LOGGER.error(INCORRECT_INPUT);
      }
    }
  }
}