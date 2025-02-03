package com.xworkz.app.service;

import com.xworkz.app.constant.ServiceConstant;
import com.xworkz.app.dto.SalesDto;
import com.xworkz.app.entity.SalesEntity;
import com.xworkz.app.repository.MediSalesRepository;
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

@Service
@Slf4j
public class MediSalesSeriveImpl implements MediSalesService{
    @Autowired
    private MediSalesRepository mediSalesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean validateAndSave(SalesDto salesDto) {
        SalesEntity salesEntity=new SalesEntity();
        boolean isAdded=false;
        if (salesDto !=null && salesDto.getCompanyName() !=null && salesDto.getContactPerson() !=null){
            BeanUtils.copyProperties(salesDto,salesEntity);
            salesEntity.setAttempt(0);
            salesEntity.setPassword(passwordEncoder.encode(salesEntity.getPassword()));
            salesEntity.setCreatedBy(salesDto.getCreatedBy());
            salesEntity.setCreatedDate(LocalDate.now());
            isAdded=mediSalesRepository.saveDetails(salesEntity);
        }
        return isAdded;
    }

    @Override
    public SalesDto validateSignIn(String email, String password) {
        log.info("validation method in service impl");
        SalesDto userDto = new SalesDto();
        SalesEntity userEntity = mediSalesRepository.findByEmail(email);
        log.info("userenity in signin {} ",userEntity);
        if (userEntity != null && userEntity.getRegEmail()!=null && userEntity.getPassword() !=null
                && userEntity.getRegEmail().equalsIgnoreCase(email) &&
                passwordEncoder.matches(password,userEntity.getPassword())) {
            BeanUtils.copyProperties(userEntity,userDto);
            userEntity.setAttempt(0);
           mediSalesRepository.updateProfile(userEntity);
            return userDto;
        }else {
            SalesEntity userEntity1=mediSalesRepository.findByEmail(email);
            log.info("attempt entity: {}",userEntity1);
            userEntity1.setAttempt(userEntity1.getAttempt()+1);
           mediSalesRepository.updateProfile(userEntity1);
            log.info("No of attempts: {}",userEntity1.getAttempt());

            SalesDto userDto1=new SalesDto();
            userDto1.setAttempt(userEntity1.getAttempt());
            log.info("user dto1: {}",userDto1.getAttempt());
            return userDto1;
        }
    }

    @Override
    public SalesDto getById(Integer id) {
        SalesEntity userEntity = mediSalesRepository.getById(id);
        SalesDto userDto = new SalesDto();
        if (userEntity != null) {
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }
        return null;    }

    @Override
    public SalesDto updateProfile(SalesDto salesDto, SalesDto sessionDto, MultipartFile multipartFile) {
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
        SalesDto userDtoById = getById(salesDto.getId());
        SalesEntity userEntity = new SalesEntity();
        BeanUtils.copyProperties(salesDto, userEntity);

        BeanUtils.copyProperties(userEntity, salesDto);
        userEntity.setPassword(sessionDto.getPassword());
        userEntity.setConfirmPassword(sessionDto.getConfirmPassword());
        userEntity.setCreatedDate(sessionDto.getCreatedDate());
        userEntity.setCreatedBy(sessionDto.getCreatedBy());
        userEntity.setUpdatedDate(LocalDate.now());
        userEntity.setFileName(multipartFile.getOriginalFilename());
        userEntity.setContentType(multipartFile.getContentType());
        SalesEntity updateUserEntity = mediSalesRepository.updateProfile(userEntity);


        SalesDto dto = new SalesDto();
        BeanUtils.copyProperties(updateUserEntity, dto);
        return dto;
    }
}
