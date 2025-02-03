package com.xworkz.app.service;

import com.xworkz.app.dto.SalesDto;
import org.springframework.web.multipart.MultipartFile;

public interface MediSalesService {
    boolean validateAndSave(SalesDto dto);
    SalesDto validateSignIn(String email,String password);
    SalesDto getById(Integer id);
     SalesDto updateProfile(SalesDto salesDto, SalesDto sessionDto, MultipartFile multipartFile);
}
