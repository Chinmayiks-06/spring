package com.xworkz.app.dao;

import com.xworkz.app.dto.ProductDto;

public interface ProductDao {

    boolean addProduct(ProductDto productDto);

    ProductDto getProductById(int id);
    boolean updateProductPriceById(double price , int id);
    boolean deleteProduct(int id);

    String getProductNameById(int id);

    double getProductPriceById(int id);

    String getProductTypeByProductName(String name);

      Object[] getProductNameAndProductPriceById(int id);

      Object[] getProductColorAndProductTypeByProductName(String name);


}
