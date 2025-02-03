package com.xworkz.app.service;

import com.xworkz.app.dao.ProductDao;
import com.xworkz.app.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.NameNotFoundException;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    public ProductDao productDao;
    public boolean validateAndAddProduct(ProductDto productDto) {
        boolean isProductAdded=false;
        boolean isProductNameAdded=false;
        if(productDto!=null){
            if(productDto.getProductName()!=null && !productDto.getProductName().isEmpty()){
                isProductNameAdded=true;
            }
            if(isProductNameAdded==true){
                isProductAdded=productDao.addProduct(productDto);
            }
        }
        return isProductAdded;
    }
    @Override
    public ProductDto validateAndGetProductById(int id) {
        return productDao.getProductById(id);
    }
    @Override
    public boolean validateAndUpdateProductPriceById(double price, int id) {
        boolean isPriceUpdated=false;
        if(id > 0){
              if(price > 0){
                  isPriceUpdated=productDao.updateProductPriceById(price,id);

              }
        }
        return isPriceUpdated;
    }
    @Override
    public boolean validateAndDeleteProduct(int id) {
        boolean isPatientDeleted=false;
        if(id > 0){
            isPatientDeleted=productDao.deleteProduct(id);
        }
        return isPatientDeleted;
    }
    @Override
    public String validateAndGetProductNameById(int id) throws NameNotFoundException {
        String name=null;
        if(id > 0){
            name=productDao.getProductNameById(id);
        }
        if(name==null){
            throw  new NameNotFoundException("Name Not Found For This Id ="+id);
        }
        return name;
    }
    @Override
    public double validateAndGetProductPriceById(int id) {
        return productDao.getProductPriceById(id);
    }
    @Override
    public String validateAndGetProductTypeByProductName(String name) {
        return productDao.getProductTypeByProductName(name);
    }
    @Override
    public Object[] validateAndGetProductNameAndProductPriceById(int id) {
        return productDao.getProductNameAndProductPriceById(id);
    }
    @Override
    public Object[] validateAndGetProductColorAndProductTypeByProductName(String name) {
        return productDao.getProductColorAndProductTypeByProductName(name);
    }
}
