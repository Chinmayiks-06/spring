package com.xworkz.app.repository;

import com.xworkz.app.entity.SalesEntity;

public interface MediSalesRepository {

    boolean saveDetails(SalesEntity salesEntity);
    SalesEntity findByEmail(String email);
    SalesEntity getById(Integer id);
    SalesEntity updateProfile(SalesEntity userEntity);

}
