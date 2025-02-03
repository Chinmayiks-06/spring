package com.xworkz.app.dao;

import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.AddressNotFoundException;
import com.xworkz.app.exception.NameNotFoundException;
import com.xworkz.app.exception.PhoneNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

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

    @Override
    public String getUserNameById(int id) throws NameNotFoundException {
        try {
            return (String) entityManagerFactory.createEntityManager().
                    createNamedQuery("getUserNameById").
                    setParameter("i",id).getSingleResult();

        }
        catch (Exception e){
            System.out.println("not found");
            return null;
        }
    }

    @Override
    public Long getPhNoById(int id) {
        try {
            return (Long) entityManagerFactory.createEntityManager().
                    createNamedQuery("getPhNoById").
                    setParameter("i", id).getSingleResult();
        }
        catch (RuntimeException e){
            System.out.println("not found");
            return null;
        }

    }

    @Override
    public String getAddressById(int id)  {
        try {
            return (String) entityManagerFactory.createEntityManager().
                    createNamedQuery("getAddressById").
                    setParameter("i", id).getSingleResult();
        }
        catch (Exception e){
            System.out.println("address not found");
            return null;
        }
    }

    @Override
    public Object[] getUserNameAndPhNoById(int id) {
       // return (Object[]) entityManagerFactory.createEntityManager().createQuery("select user.userName, user.phNo from UserDto user where user.userId=:i").setParameter("i", id).getSingleResult();
        return (Object[]) entityManagerFactory.createEntityManager().
                createNamedQuery("getUserNameByPhNo").
                setParameter("i", id).getSingleResult();
    }

    @Override
    public Object[] getUserNameAndAddressById(int id) {
        return (Object[]) entityManagerFactory.createEntityManager().createNamedQuery("getUserNameAndAddressById").setParameter("ref",id).getSingleResult();

    }

    @Override
    public Object[] getUserNameAndAddressByPhNo(long phNo) {
        return (Object[]) entityManagerFactory.createEntityManager().
                createQuery("getUserNameAndAddressByPhNo").
                setParameter("pn",phNo).getSingleResult();
    }

    @Override
    public boolean editAddressByPhNo(String address,long phNo) {
        boolean isAddressUpdated=false;
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("update UserDto dto set dto.address=:add where dto.phNo=:pNo");
        query.setParameter("add",address);
        query.setParameter("pNo",phNo);
        int noOfRowsUpdated= query.executeUpdate();
        entityManager.getTransaction().commit();
        if(noOfRowsUpdated>0)
            return true;
        return isAddressUpdated;
    }

    @Override
    public boolean removeUserByPhNo(long phNo) {
        boolean isUserDeleted=false;
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("delete UserDto dto where dto.phNo=:pNo");
        entityManager.getTransaction().begin();
        query.setParameter("pNo",phNo);
        int noOfRowsDeleted= query.executeUpdate();
        entityManager.getTransaction().commit();
        if(noOfRowsDeleted>0)
            return true;
        return isUserDeleted;
    }

    @Override
    public List<Object[]> getUserNameAndAddress() {
        return entityManagerFactory.createEntityManager().
                createQuery("select user.userName, user.address from UserDto user").
                getResultList();
    }

}
