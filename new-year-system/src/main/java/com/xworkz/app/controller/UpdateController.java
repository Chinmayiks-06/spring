package com.xworkz.app.controller;


import com.xworkz.app.dto.UserDto;
import com.xworkz.app.service.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@Slf4j
public class UpdateController {
    @Autowired
    UserRegistrationService service;

    /*@GetMapping("update/{id}")
    public String getUpdatePage(@PathVariable Integer id, Model model){
        log.info("Id is :{} ",id);
        UserDto userDto=service.getById(id);
        model.addAttribute("dto",userDto);
        return "Update";
    }*/
    @GetMapping("update")
    public String getUpdatePage(@RequestParam Integer id, Model model, HttpSession httpSession){

        log.info("Id is :{} ",id);
        UserDto userDto=service.getById(id);
        httpSession.setAttribute("user",userDto);
        model.addAttribute("dto",userDto);
        return "Update";

    }
}
