package com.xworkz.app.repository;

import com.xworkz.app.entity.SalesEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Component
@Repository
@Transactional
@Slf4j
public class MediSalesRepositoryImpl implements MediSalesRepository{
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveDetails(SalesEntity salesEntity) {
        log.info("save method is started");
       EntityManager entityManager=entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.persist(salesEntity);
       entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public SalesEntity findByEmail(String email) {
        try {
            if (email !=null){
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                Query query = entityManager.createNamedQuery("checkEmailToLogin",SalesEntity.class);
                query.setParameter("em", email);
                return (SalesEntity) query.getSingleResult();
            }
        } catch (Exception e) {
            log.error("Error finding user by email: {}", e.getMessage());
        }
        return null;
    }

    @Override
    public SalesEntity getById(Integer id) {
        return entityManagerFactory.createEntityManager().find(SalesEntity.class,id);

    }

    @Override
    public SalesEntity updateProfile(SalesEntity userEntity) {
            EntityManager entityManager=entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            SalesEntity profileValidated= entityManager.merge(userEntity);
            entityManager.getTransaction().commit();
            return profileValidated;
    }


}
