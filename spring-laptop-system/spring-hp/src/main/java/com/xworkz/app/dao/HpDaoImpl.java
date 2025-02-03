package com.xworkz.app.dao;

import com.xworkz.app.dto.HpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
@Component
public class HpDaoImpl implements HpDao{
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public boolean addUserDetails(HpDto dto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(dto);
        entityManager.getTransaction().commit();
        // entityManager.close();
        return true;
    }

    @Override
    public HpDto getDetailsById(int id) {
        return null;
    }


    @Override
    public Object[] getNameAndSerialNoByEmail(String email) {
        return (Object[]) entityManagerFactory.createEntityManager().createNamedQuery("getNameAndSerialNoByEmail").
                setParameter("email",email).getSingleResult();
    }

    @Override
    public String getSerialNoById(int id) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getSerialNoById")
                .setParameter("i",id).getSingleResult();
    }

    @Override
    public String getEmailBySerialNo(String serialNo) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getEmailBySerialNo")
                .setParameter("s",serialNo).getSingleResult();
    }

    @Override
    public String getEmailById(int id) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getEmailById")
                .setParameter("i",id).getSingleResult();
    }

    @Override
    public String getNameBySerialNo(String serialNo) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getNameBySerialNo")
                .setParameter("s",serialNo).getSingleResult();
    }

    @Override
    public String getPasswordByEmail(String email) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getPasswordByEmail").
                setParameter("e",email).getSingleResult();
    }

    @Override
    public boolean updatePasswordByEmail(String password, String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("updatePasswordByEmail");
        query.setParameter("pass",password);
        query.setParameter("e",email);
        int update = query.executeUpdate();
        entityManager.getTransaction().commit();
        if(update>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteUserBySerialNo(String serialNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("deleteUserBySerialNo");
        query.setParameter("s",serialNo);
        int update = query.executeUpdate();
        entityManager.getTransaction().commit();
        if(update>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteUserByName(String firstName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("deleteUserByName");
        query.setParameter("f",firstName);
        int update = query.executeUpdate();
        entityManager.getTransaction().commit();
        if(update>0)
            return true;
        return false;
    }
}
