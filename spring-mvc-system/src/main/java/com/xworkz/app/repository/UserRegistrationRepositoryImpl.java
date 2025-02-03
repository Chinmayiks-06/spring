package com.xworkz.app.repository;

import com.xworkz.app.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserRegistrationRepositoryImpl implements UserRegistrationRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(UserDto dto) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(dto);
        entityManager.getTransaction().commit();

        return true;
    }

    public List<UserDto> getAllUsers() {
        return entityManagerFactory.createEntityManager().createNamedQuery("getAllDetails").getResultList();

    }
}
