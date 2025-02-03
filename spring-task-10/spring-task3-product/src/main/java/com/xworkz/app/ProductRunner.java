package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.ProductDto;
import com.xworkz.app.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Laptop");
        productDto.setProductPrice(69000.00);
        productDto.setProductType("Electronic");
        productDto.setQuantity(1);
        productDto.setProductColor("Grey");

       ProductService productService =applicationContext.getBean(ProductService.class);
       productService.validateAndAddProduct(productDto);
    }
}
