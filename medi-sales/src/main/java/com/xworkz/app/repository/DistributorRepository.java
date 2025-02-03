package com.xworkz.app.repository;

import com.xworkz.app.dto.DistributorDto;
import com.xworkz.app.entity.DistributorEntity;

import java.util.List;

public interface DistributorRepository {

 boolean save(DistributorEntity distributorEntity);
 List<DistributorDto> getAlldistributors();

}
