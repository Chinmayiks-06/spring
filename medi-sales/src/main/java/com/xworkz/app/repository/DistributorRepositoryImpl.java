package com.xworkz.app.repository;

import com.xworkz.app.dto.DistributorDto;
import com.xworkz.app.entity.DistributorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
public class DistributorRepositoryImpl implements DistributorRepository{

@Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public boolean save(DistributorEntity distributorEntity) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(distributorEntity);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }

    @Override
    public List<DistributorDto> getAlldistributors() {
        return entityManagerFactory.createEntityManager().createNamedQuery("getAllUsers").getResultList();
    }
}
