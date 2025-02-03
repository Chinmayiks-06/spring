package com.xworkz.app.service;

import com.xworkz.app.constant.MessageConstant;
import com.xworkz.app.constant.ServiceConstant;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.entity.UserEntity;
import com.xworkz.app.repository.UserRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;


@Slf4j
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    public boolean validateAndSave(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        if (userDto.getFirstName() != null && userDto.getLastName() != null) {
            BeanUtils.copyProperties(userDto, userEntity);
            userEntity.setAttempt(0);
            userEntity.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
            userEntity.setCreatedBy(userDto.getFirstName());
            userEntity.setCreatedDate(LocalDate.now());
            repository.saveDetails(userEntity);
            mailService.sendEmail("Registration", "Thank you for registering " + userDto.getFirstName(), userDto.getEmail());
            log.info("email sent successfully to:{}", userDto.getEmail());
        } else {

        }
        return true;
    }

    @Override
    public UserDto validateSignIn(String email, String password) {
        log.info("validation method in service impl");
        UserDto userDto = new UserDto();
        UserEntity userEntity = repository.findByEmail(email);
        log.info("userenity in signin {} ",userEntity);
        if (userEntity != null && userEntity.getEmail()!=null && userEntity.getUserPassword() !=null
                && userEntity.getEmail().equalsIgnoreCase(email) &&
                passwordEncoder.matches(password,userEntity.getUserPassword())) {
            BeanUtils.copyProperties(userEntity,userDto);
            userEntity.setAttempt(0);
            repository.updateProfile(userEntity);
            return userDto;
        }else {
            UserEntity userEntity1=repository.findByEmail(email);
            log.info("attempt entity: {}",userEntity1);
            userEntity1.setAttempt(userEntity1.getAttempt()+1);
            repository.updateProfile(userEntity1);
            log.info("No of attempts: {}",userEntity1.getAttempt());

            UserDto userDto1=new UserDto();
            userDto1.setAttempt(userEntity1.getAttempt());
            log.info("user dto1: {}",userDto1.getAttempt());
            return userDto1;
        }
    }


    @Override
    public UserDto getById(Integer id) {
        UserEntity userEntity = repository.getByid(id);
        UserDto userDto = new UserDto();
        if (userEntity != null) {
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto updateProfile(UserDto userDto, UserDto sesionDto, MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            log.info("file is empty");
        } else {
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(ServiceConstant.FILE_PATH.getPath() + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                log.error("{}", e.getMessage());
            }

        }
        UserDto userDtoById = getById(userDto.getId());
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        BeanUtils.copyProperties(userEntity, userDto);
        userEntity.setUserPassword(sesionDto.getUserPassword());
        userEntity.setConfirmPassword(sesionDto.getConfirmPassword());
        userEntity.setCreatedBy(sesionDto.getCreatedBy());
        userEntity.setCreatedDate(sesionDto.getCreatedDate());
        userEntity.setUpdatedBy(sesionDto.getFirstName());
        userEntity.setFileName(multipartFile.getOriginalFilename());
        userEntity.setContentType(multipartFile.getContentType());
        userEntity.setUpdateDate(LocalDate.now());
        UserEntity updateUserEntity = repository.updateProfile(userEntity);


        UserDto dto = new UserDto();
        BeanUtils.copyProperties(updateUserEntity, dto);
        return dto;
    }

    @Override
    public boolean valdateOtp(String otp, String email) {

        UserEntity userEntity=repository.findByEmail(email);
        if (userEntity !=null && userEntity.getEmail() !=null
        && userEntity.getEmail().equalsIgnoreCase(email) &&
        userEntity.getOtp() !=null && passwordEncoder.matches(otp, userEntity.getOtp())){
            log.info(MessageConstant.OTP_VALIDATE_MESSAGE.getMessage());
            return true;
        }else {
            log.info(MessageConstant.OTP_VALIDATE_REJECT_MESSAGE.getMessage());
            return false;
        }
    }


}

