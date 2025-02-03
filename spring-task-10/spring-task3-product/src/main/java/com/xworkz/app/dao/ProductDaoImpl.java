package com.xworkz.app.dao;

import com.xworkz.app.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Component
public class ProductDaoImpl implements ProductDao{

    @Autowired
    public EntityManagerFactory entityManagerFactory;
    public boolean addProduct(ProductDto productDto) {

        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(productDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    @Override
    public ProductDto getProductById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        ProductDto productDto=entityManager.find(ProductDto.class,id);
        return productDto;
    }

    @Override
    public boolean updateProductPriceById(double price, int id) {
          EntityManager entityManager=entityManagerFactory.createEntityManager();
          entityManager.getTransaction().begin();
          Query query = entityManager.createNamedQuery("updateProductPriceById");
          query.setParameter("price",price);
          query.setParameter("id",id);
          query.executeUpdate();
          entityManager.getTransaction().commit();
        return true;
    }
    @Override
    public boolean deleteProduct(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("deleteProduct");
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        return true;
    }
    @Override
    public String getProductNameById(int id) {
        return (String) entityManagerFactory.createEntityManager().createNamedQuery("getProductNameById").
                setParameter("id",id).getSingleResult();

    }
    @Override
    public double getProductPriceById(int id) {
       return(Double) entityManagerFactory.createEntityManager().createNamedQuery("getProductPriceById").
                setParameter("id",id).getSingleResult();
    }
    @Override
    public String getProductTypeByProductName(String name) {
       return (String) entityManagerFactory.createEntityManager().createNamedQuery("getProductTypeByProductName").
               setParameter("name",name).getSingleResult();
    }
    @Override
    public Object[] getProductNameAndProductPriceById(int id) {
      return(Object[]) entityManagerFactory.createEntityManager().createNamedQuery("getProductNameAndProductPriceById").
               setParameter("id",id).getSingleResult();
    }
    @Override
    public Object[] getProductColorAndProductTypeByProductName(String name) {
      return(Object[]) entityManagerFactory.createEntityManager().createNamedQuery("getProductColorAndProductTypeByProductName").
               setParameter("name",name).getSingleResult();
    }
}
