package com.xworkz.app.controller;

import com.xworkz.app.dto.SalesDto;
import com.xworkz.app.service.MediSalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class MediSalesRegController {
   @Autowired
   MediSalesService service;

   @GetMapping("SignUp")
   public String SignUp(){
      return "SignUp";
   }
   @GetMapping("response")
   public String response(){
      return "response";
   }
   @GetMapping("login")
   public String login(){
      return "login";
   }
   @GetMapping("index")
   public String index(){
      return "index";
   }


   @PostMapping("signup")
   public String onSave(@Valid SalesDto salesDto, BindingResult bindingResult, Model model){
   boolean hasErrors = bindingResult.hasErrors();
      if (bindingResult.hasErrors()) {
         model.addAttribute("salesDto", salesDto);

         List<ObjectError> allErrors = bindingResult.getAllErrors();
         allErrors.forEach(error -> {
            FieldError fieldError = (FieldError) error;
            System.out.println(fieldError.getField() + " Error msg: " + fieldError.getDefaultMessage());

            switch (fieldError.getField()) {
               case "companyName":
                  model.addAttribute("companyNameError", fieldError.getDefaultMessage());
                  break;
               case "contactPerson":
                  model.addAttribute("contactPersonError", fieldError.getDefaultMessage());
                  break;
               case "regNumber":
                  model.addAttribute("mobileNumberError", fieldError.getDefaultMessage());
                  break;
               case "regEmail":
                  model.addAttribute("emailError", fieldError.getDefaultMessage());
                  break;
               case "addressOne":
                  model.addAttribute("addressOneError", fieldError.getDefaultMessage());
                  break;
               case "pincode":
                  model.addAttribute("pincodeError", fieldError.getDefaultMessage());
                  break;
               case "password":
                  model.addAttribute("passwordError", fieldError.getDefaultMessage());
                  break;
               case "confirmPassword":
                  model.addAttribute("confirmPasswordError", fieldError.getDefaultMessage());
                  break;
               default:
                  model.addAttribute(fieldError.getField() + "Error", fieldError.getDefaultMessage());
                  break;
            }
         });
      return "SignUp";
   }

   service.validateAndSave(salesDto);
   model.addAttribute("name", salesDto.getCompanyName());
   return "response";

}
   @PostMapping("signin")
   public String signIn(@RequestParam String email, @RequestParam String password, Model model) {

      SalesDto userDto=service.validateSignIn(email,password);
      if (userDto != null && userDto.getCompanyName()!=null &&
              userDto.getRegEmail().equalsIgnoreCase(email) &&
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
         return  "login";

      }
   }

}
