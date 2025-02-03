package com.xworkz.app.service;

import com.xworkz.app.entity.UserEntity;
import com.xworkz.app.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
//null pointer exception
@Slf4j
public class AjaxServiceImpl implements AjaxService{

    @Autowired
    private UserRegistrationRepository repository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String checkEmail(String email) {
        boolean exists = repository.checkEmail(email);
        if (exists){
            return "Email already exists";
        }else {
            return "Email doesnt exists";
        }
    }

    @Override
    public String sendOtp(String email) {

        UserEntity userEntity=repository.findByEmail(email);
        System.err.println(userEntity);
        if (userEntity != null && userEntity.getEmail() !=null){
            Random random=new Random();
            Integer otp= random.nextInt(9999);
            log.info("your otp is :{}",otp);
            mailService.sendEmail("OTP verification","<b> your otp is ::  </b>"+otp,email);
            userEntity.setOtp(passwordEncoder.encode(otp.toString()));
            repository.updateProfile(userEntity);
            return "OTP sent successfully to " + email;
        }
        return "User not found with the provided email";
    }







   /* @Override
    public String checkContact(long contact) {
        boolean exists = repository.findContact(contact);
        if (exists){
            return "Email already exists";
        }else {
            return "Email doesnt exists";
        }*/
    //}
}
