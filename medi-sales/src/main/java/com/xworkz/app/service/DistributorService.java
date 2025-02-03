package com.xworkz.app.service;

import com.xworkz.app.dto.DistributorDto;

import java.util.List;

public interface DistributorService {
    boolean validAndSave(DistributorService distributorDto);

    List<DistributorDto> getAllDistributors();
}
