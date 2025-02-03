package com.xworkz.app.runner;

import com.xworkz.app.config.SpringConfig;
import com.xworkz.app.dto.AmazonDto;
import com.xworkz.app.service.AmazonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class AmazonRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        AmazonDto amazonDto = new AmazonDto();
        amazonDto.setProductName("Kurta");
        amazonDto.setBrand("Zudio");
        amazonDto.setProductPrice(1255.20);
        amazonDto.setColor("Pink");
        amazonDto.setQuantity(3);

        AmazonService amazonService = applicationContext.getBean(AmazonService.class);
        amazonService.saveAndValidate(amazonDto);
        System.out.println("Product added successfully...!!!");

       /* //get by id
        AmazonDto amazonDto1 = amazonService.getUserById(5);
        System.out.println(amazonDto1);

        //get all details
        List<AmazonDto> amazonDtos = amazonService.getAllDetails(amazonDto);
        System.out.println(amazonDtos);

        //delete by Id
        int productIdToDelete = 8;

        boolean isDeleted = amazonService.deleteProductId(productIdToDelete);

        System.out.println("User with ID " + productIdToDelete + " deleted successfully.");

        System.out.println("getNameByPrice");
        System.out.println(amazonService.getNameByPrice(1200));

        System.out.println("getBrandNameByid");
        Object[] obj = amazonService.getBrandNameByid(2);
        Arrays.stream(obj).forEach(System.out::println);

        System.out.println("getColorQuantityByName");
        Object[] obj1 = amazonService.getColorQuantityByName("Television");
        Arrays.stream(obj1).forEach(System.out::println);

        System.out.println("getPriceByQuantity");
        System.out.println(amazonService.getPriceByQuantity(2));

        System.out.println("getNameByBrand");
        System.out.println(amazonService.getNameByBrand("Okea"));*/
    }
}
