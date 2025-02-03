package com.xworkz.mall.runner;

import com.xworkz.mall.config.SpringConfiguration;
import com.xworkz.mall.dto.MallDto;
import com.xworkz.mall.service.MallService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MallRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        MallDto mallDto = new MallDto();
        MallService mallService = applicationContext.getBean(MallService.class);

        mallDto.setMallName("Palladium");
        mallDto.setMallArea("Senapathi");
        mallDto.setNoOfFloors(5);
        mallDto.setCity("Maharastra");

        //validate and save the details;
        mallService.validatedAndSave(mallDto);
        System.out.println(mallDto);

      /*  //get by id;
        MallDto mallDto1 = mallService.getUserById(2);
        System.out.println(mallDto1);

        //get all details
        List<MallDto> mallDtos = mallService.getAllDetails(mallDto);
        System.out.println(mallDtos);

        //update operation;
        MallDto newmall = new MallDto();
        newmall.setMallName("Oberoi Mall");
        newmall.setMallArea("Yashodham");
        newmall.setNoOfFloors(6);
        newmall.setCity("Mumbai");

        mallService.updateUserById(7,newmall);
        System.out.println("Updated sucessfully...!!");

        //delete operation;
        mallService.DeleteUserById(8);
        System.out.println("Deleted the row...!!");

        //get City by name
        System.out.println("get City by name");
        System.out.println(mallService.getCitybyname("Oberoi Mall"));

        System.out.println("getFloorsbyName");
        System.out.println(mallService.getFloorsbyName("Lulu Mall"));

        System.out.println("getNameByArea");
        System.out.println(mallService.getNameByArea("Yelahanka"));

        System.out.println("get name area and no of floors by city");
        Object [] obj = mallService.getNameAreaFloorsByCity("Mumbai");
        Arrays.stream(obj).forEach(System.out::println);

        System.out.println("get city and name by no of floors");
        Object [] obj1 = mallService.getCityNameByFloors(6);
        Arrays.stream(obj1).forEach(System.out::println);*/
    }
}
