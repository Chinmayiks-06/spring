package com.xworkz.app.controller;

import com.xworkz.app.constant.ServiceConstant;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.service.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService service;

    @PostMapping("user")
    public String onSave(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        boolean hasErrors = bindingResult.hasErrors();
        if (hasErrors) {
            model.addAttribute("userDto", userDto);
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(errors -> {
                FieldError fieldError = (FieldError) errors;
                System.out.println(fieldError.getField() + "Error msg" + fieldError.getDefaultMessage());
                if (fieldError.getField().equalsIgnoreCase("firstName")) {
                    model.addAttribute("firstNameError", fieldError.getDefaultMessage());
                }
                if (fieldError.getField().equalsIgnoreCase("lastName")) {
                    model.addAttribute("lastNameError", fieldError.getDefaultMessage());
                }
                if (fieldError.getField().equalsIgnoreCase("email")) {
                    model.addAttribute("emailError", fieldError.getDefaultMessage());
                }
            });
            return "Registration";
        }
        service.validateAndSave(userDto);
        model.addAttribute("name", userDto.getFirstName());
        return "response";
    }


    @PostMapping("signin")
    public String signIn(@RequestParam String email, @RequestParam String password, Model model) {

        UserDto userDto=service.validateSignIn(email,password);
        if (userDto != null && userDto.getFirstName()!=null &&
                userDto.getEmail().equalsIgnoreCase(email) &&
                userDto.getAttempt()<=3){
            model.addAttribute("dto", userDto);
            model.addAttribute("id",userDto.getId() );
            return "dashboard";
        } else{
            model.addAttribute("email",email);
            model.addAttribute("valid","Email or password doesn't match");
            if (userDto.getAttempt() >= 3){
                model.addAttribute("valid","account is blocked");
        }
            return  "Signin";

        }
    }

    /*@PostMapping("update/updateProfile")
    public String updateProfile(UserDto userDto,Model model){
        log.info("{}",userDto);
        UserDto userDto1=service.updateProfile(userDto);

        model.addAttribute("dto",userDto);
        model.addAttribute("success","Successfully updated");
        return "Update";
*/
    @PostMapping("updateProfile")
    public String updateProfile(UserDto userDto, Model model, HttpServletRequest request,@RequestParam("file") MultipartFile multipartFile){
        log.info("{}: ",multipartFile.getOriginalFilename());
        log.info("{}",userDto);
        UserDto sessionDto=(UserDto) request.getSession().getAttribute("user");
        log.info("{}",sessionDto);
        UserDto userDto1=service.updateProfile(userDto,sessionDto,multipartFile);

        model.addAttribute("dto",userDto1);
        model.addAttribute("success","Successfully updated");
        return "Update";

    }
    @GetMapping("view/{imageName}")
    public  void getImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        Path path=Paths.get(ServiceConstant.FILE_PATH.getPath()+imageName);
        log.info("{}",path);

        //send image in your jsp        qqq
        Files.copy(path,response.getOutputStream());
        response.getOutputStream().flush();
    }

    @PostMapping("validateOtp")
   public  String validateOtp(@RequestParam String otp,@RequestParam String email,Model model){
        log.info("otp is : {} Email is :{}",otp,email);
        if (service.valdateOtp(otp, email)){
            log.info("Validation result: {}", service.valdateOtp(otp, email));
            model.addAttribute("email",email);
            return "resetPassword";
        }else {
            return "forgetPassword";
        }
    }



}
