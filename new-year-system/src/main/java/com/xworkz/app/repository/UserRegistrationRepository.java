package com.xworkz.app.repository;

import com.xworkz.app.entity.UserEntity;


public interface UserRegistrationRepository {
    boolean saveDetails(UserEntity userEntity);
    UserEntity findByEmail(String email);
    UserEntity getByid(Integer id);
    UserEntity updateProfile(UserEntity userEntity);
    boolean checkEmail(String email);
    boolean  checkContact(Long contact);

}
