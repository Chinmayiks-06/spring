package com.xworkz.app.dao;

import com.xworkz.app.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private EntityManagerFactory factory;


    @Override
    public boolean save(CustomerDto customerDto) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customerDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public CustomerDto getUserById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CustomerDto Dto = entityManager.find(CustomerDto.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return Dto;
    }

    @Override
    public List<CustomerDto> getAllDetails(CustomerDto customerDto) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createNamedQuery("getAllDetails");
        List<CustomerDto> Dtos = query.getResultList();
        return Dtos;
    }

    @Override
    public void updateUserById(int id, CustomerDto newUserData) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CustomerDto dto = entityManager.find(CustomerDto.class,id);
        if(dto != null){
            dto.setCustomerName(dto.getCustomerName());
            dto.setEmail(dto.getEmail());
            dto.setCustomerNo(dto.getCustomerNo());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean DeleteUserById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("DeleteUserById");
        query.setParameter("id",id);
        int rowsDeleted = query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return rowsDeleted > 0;
    }

    @Override
    public String getNameByNo(int no) {
        return (String) factory.createEntityManager().createNamedQuery("getNameByNo").
                setParameter("no",no).getSingleResult();
    }

    @Override
    public String getEmailByNo(int no) {
        return (String) factory.createEntityManager().createNamedQuery("getEmailByNo").
                setParameter("no",no).getSingleResult();
    }

    @Override
    public Object[] getNoAndNameByEmail(String email) {
        return (Object[]) factory.createEntityManager().createNamedQuery("getNoAndNameByEmail").
                setParameter("email",email).getSingleResult();
    }

    @Override
    public boolean updateNoByName(int no, String name) {
        boolean isUpdated = false;
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("updateNoByName");
        query.setParameter("no",no);
        query.setParameter("name",name);
        int rowEffected = query.executeUpdate();
        entityManager.getTransaction().commit();
        if(rowEffected > 0)
            isUpdated = true;
        return  isUpdated;
    }

    @Override
    public boolean deleteCustomerByEmail(String email) {
        boolean isDeleted = false;
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("deleteCustomerByEmail");
        query.setParameter("email",email);
        int rowEffected = query.executeUpdate();
        entityManager.getTransaction().commit();
        if(rowEffected > 0)
            isDeleted = true;
        return  isDeleted;
    }
}

