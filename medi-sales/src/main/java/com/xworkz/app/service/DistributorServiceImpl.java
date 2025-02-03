package com.xworkz.app.service;

import com.xworkz.app.dto.DistributorDto;
import com.xworkz.app.repository.DistributorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class DistributorServiceImpl implements DistributorService{

    @Autowired
    DistributorRepository distributorRepository;

    @Override
    public boolean validAndSave(DistributorService distributorDto) {
        return false;
    }

    @Override
    public List<DistributorDto> getAllDistributors() {
        return Collections.emptyList();
    }
}
