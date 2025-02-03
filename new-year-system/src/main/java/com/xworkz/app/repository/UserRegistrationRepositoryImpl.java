package com.xworkz.app.repository;

import com.xworkz.app.entity.UserEntity;
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
public class UserRegistrationRepositoryImpl implements UserRegistrationRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveDetails(UserEntity userEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();
        return true;
    }

//    @Override
//    public UserEntity findByEmailAndPassword(String email,String password) {
//        try {
//            EntityManager entityManager=entityManagerFactory.createEntityManager();
//              Query query     = entityManager.createNamedQuery("checkEmailAndPassword");
//              query.setParameter("em",email);
//              query.setParameter("pass",password);
//              UserEntity userEntity=(UserEntity) query.getSingleResult();
//              entityManager.close();
//              return userEntity;
//        }catch (Exception e){
//        log.info("{}",e.getMessage());
//        }
//       return new UserEntity();
//    }

    public UserEntity findByEmail(String email) {
        try {
            if (email !=null){
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                Query query = entityManager.createNamedQuery("checkEmailAndPassword",UserEntity.class);
                query.setParameter("em", email);
                return (UserEntity) query.getSingleResult();
            }
        } catch (Exception e) {
            log.error("Error finding user by email: {}", e.getMessage());
        }
        return null;
    }


    @Override
    public UserEntity getByid(Integer id) {
        return entityManagerFactory.createEntityManager().find(UserEntity.class,id);
    }

    @Override
    public UserEntity updateProfile(UserEntity userEntity) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       UserEntity profileValidated= entityManager.merge(userEntity);
        entityManager.getTransaction().commit();
        return profileValidated;
    }

    @Override
    public boolean checkEmail(String email){
    try {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("checkEmail");
        query.setParameter("em", email);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }catch (Exception e){
        log.info("{}",e.getMessage());
    }
        return true;
    }

    @Override
    public boolean checkContact(Long contact) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("checkContact");
            query.setParameter("cc", contact);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        }catch (Exception e){
            log.info("{}",e.getMessage());
        }
        return true;
    }

    }
