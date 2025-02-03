package com.xworkz.app.service;

import com.xworkz.app.dto.UserDto;
import com.xworkz.app.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserRegistrationService {

    boolean validateAndSave(UserDto userDto);

    UserDto validateSignIn(String email, String password);

    UserDto getById(Integer id);

    UserDto updateProfile(UserDto userDto, UserDto sesionDto, MultipartFile multipartFile);

    boolean valdateOtp(String otp,String email);

}
