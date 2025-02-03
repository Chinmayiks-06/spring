package com.xworkz.app.service;

import com.xworkz.app.dto.ProductDto;

import javax.naming.NameNotFoundException;

public interface ProductService {
    boolean validateAndAddProduct(ProductDto productDto);

    ProductDto validateAndGetProductById(int id);
    boolean validateAndUpdateProductPriceById(double price , int id);
    boolean validateAndDeleteProduct(int id);

    String validateAndGetProductNameById(int id) throws NameNotFoundException;

    double validateAndGetProductPriceById(int id);

    String validateAndGetProductTypeByProductName(String name);

    Object[] validateAndGetProductNameAndProductPriceById(int id);

    Object[] validateAndGetProductColorAndProductTypeByProductName(String name);
}
