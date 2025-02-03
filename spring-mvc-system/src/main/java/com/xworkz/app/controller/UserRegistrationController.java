package com.xworkz.app.controller;


import com.xworkz.app.dto.UserDto;
import com.xworkz.app.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/")

public class UserRegistrationController {

    @Autowired
    UserRegistrationService service;

    @PostMapping("user")
    public String onSave(UserDto userDto, Model model){
        model.addAttribute("name",userDto.getUserName());
        service.validateAndSave(userDto);
        return "response.jsp";
    }

    @GetMapping("getAllUsers")
    public String getAllUsers(Model model){
        List<UserDto> userDtos=service.getAllUsers();
        model.addAttribute("ListOfUsers",userDtos);
        return "getalluser.jsp";
    }

}
