package com.epam.prykhodko.command.impl;

import com.epam.prykhodko.command.Command;
import com.epam.prykhodko.repository.ProductRepository;
import com.epam.prykhodko.service.ProductService;
import com.epam.prykhodko.service.impl.ProductServiceImpl;

public class GetAllProductsCommand implements Command {

  private final ProductService productService;

  public GetAllProductsCommand(ProductRepository productRepository) {
    productService = new ProductServiceImpl(productRepository);
  }

  @Override
  public void execute() {
    productService.getAll().forEach(System.out::println);
  }
}