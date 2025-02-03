package com.xworkz.app.dao;

import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    public String getNameById(int id) {
    try{
        return (String) entityManagerFactory.createEntityManager().
                                  //or  anything
                createNamedQuery("getNameById").
                setParameter("ref",id).getSingleResult();
    }
    catch (Exception e){
        System.out.println("Name not found"+id);
        return  null;
    }

    }

    @Override
    public Boolean editAddressByPhoneNumber(String address, long phNo) {

        boolean addressUpdated=false;
       EntityManager entityManager= entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        Query query=entityManager.createNamedQuery("editAddressByPhNum");
        query.setParameter("add",address);
        query.setParameter("phoneNo",phNo);
       int noOfRowsAffected= query.executeUpdate();
        entityManager.getTransaction().commit();
        if (noOfRowsAffected>0)
            return  true;

        return addressUpdated;
    }

    @Override
    public boolean removeUserByPhoneNumber(long phNo) {
        boolean isdeleted=false;
      EntityManager entityManager  =entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
    Query query= entityManager.createQuery("delete from UserDto dto where dto.phNo =:phoneNum");
    query.setParameter("phoneNum",phNo);
    int noOfrowsAffected=query.executeUpdate();
    entityManager.getTransaction().commit();
    if (noOfrowsAffected>0)
        return  true;
    return isdeleted;
    }


}
