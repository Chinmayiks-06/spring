package com.xworkz.app.dao;


import com.xworkz.app.dto.AppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Component

public class AppDaoImpl implements  AppDao {

    @Autowired
   private EntityManagerFactory entityManagerFactory;

    public boolean addUser(AppDto appDto) {
       EntityManager entityManager =entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.persist(appDto);
       entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public AppDto getDetailsByFirstName(String userName ) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
          Query query = entityManager.createQuery("select user from AppDto user where user.userName=:fn");
          query.setParameter("fn",userName);
         AppDto appDto= (AppDto) query.getSingleResult();
        return appDto;
    }

    @Override
    public AppDto getDetailsById(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
          Query query = entityManager.createQuery("select user from AppDto user where user.id=:id");
                query.setParameter("id",id);
                AppDto appDto= (AppDto) query.getSingleResult();
        return appDto;
    }

    @Override
    public List<AppDto> getAllDetails() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from AppDto dto");
        List<AppDto> listOfUsersFromDb = query.getResultList();

        return  listOfUsersFromDb;

    }

    @Override
    public boolean deleteUserById(int id) {
        System.out.println("Delete User By Id Started");
          EntityManager entityManager =entityManagerFactory.createEntityManager();
          entityManager.getTransaction().begin();
            Query query =entityManager.createQuery("delete from AppDto dto where dto.id=:id");
             query.setParameter("id" , id);
               int noOfRowsDeleted = query.executeUpdate();
               entityManager.getTransaction().commit();
                 if(noOfRowsDeleted>0){
                   return true;
                 }
             entityManager.close();
        System.out.println("Delete User By Id Ended");
        return true;
    }

    @Override
    public boolean updateUser(AppDto appDto) {
       EntityManager entityManager =entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       entityManager.merge(appDto);
       entityManager.getTransaction().commit();
       entityManager.close();
        return true;
    }


}
