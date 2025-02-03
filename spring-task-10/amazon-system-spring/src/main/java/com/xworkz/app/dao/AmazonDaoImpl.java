package com.xworkz.app.dao;

import com.xworkz.app.dto.AmazonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class AmazonDaoImpl implements AmazonDao{

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(AmazonDto amazonDto) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(amazonDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public void UpdateProductId(int id, AmazonDto amazonDto) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        AmazonDto dto = entityManager.find(AmazonDto.class,id);
        if(dto != null){
            dto.setId(dto.getId());
            dto.setProductName(dto.getProductName());
            dto.setBrand(dto.getProductName());
            dto.setProductPrice(dto.getProductPrice());
            dto.setQuantity(dto.getQuantity());
            dto.setColor(dto.getColor());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean deleteProductId(int id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("deleteProductId");
        query.setParameter("id",id);
        int noOfRowsDeleted = query.executeUpdate();
        entityManager.getTransaction().commit();
        if (noOfRowsDeleted > 0)

            return true;
        entityManager.close();
        return false;
    }

    @Override
    public AmazonDto getUserById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        AmazonDto Dto = entityManager.find(AmazonDto.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return Dto;
    }

    @Override
    public List<AmazonDto> getAllDetails(AmazonDto amazonDto) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createNamedQuery("getAllDetails");
        List<AmazonDto> Dtos = query.getResultList();
        return Dtos;
    }

    @Override
    public String getNameByPrice(double price) {
        return (String) factory.createEntityManager().
    createNamedQuery("getNameByPrice").
                setParameter("price",price).getSingleResult();
    }

    @Override
    public Object[] getBrandNameByid(int id) {
        return (Object[]) factory.createEntityManager().
    createNamedQuery("getBrandNameByid").
                setParameter("id",id).getSingleResult();
    }

    @Override
    public Object[] getColorQuantityByName(String name) {
        return (Object[]) factory.createEntityManager().
createNamedQuery("getColorQuantityByName").
        setParameter("name",name).getSingleResult();
    }

    @Override
    public double getPriceByQuantity(int quantity) {
        return (Double) factory.createEntityManager().
                createNamedQuery("getPriceByQuantity").
            setParameter("quantity",quantity).getSingleResult();
    }

    @Override
    public String getNameByBrand(String brand) {
        return (String) factory.createEntityManager().
createNamedQuery("getNameByBrand").
   setParameter("brand",brand).getSingleResult();
    }
}
