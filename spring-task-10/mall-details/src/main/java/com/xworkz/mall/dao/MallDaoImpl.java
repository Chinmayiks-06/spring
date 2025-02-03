package com.xworkz.mall.dao;

import com.xworkz.mall.dto.MallDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Component
public class MallDaoImpl implements MallDao{

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(MallDto mallDto) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(mallDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public MallDto getUserById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        MallDto mallDto = entityManager.find(MallDto.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return mallDto;
    }

    @Override
    public List<MallDto> getAllDetails(MallDto mallDto) {

        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createNamedQuery("getAllDetails");
        List<MallDto> mallDtos = query.getResultList();
        return mallDtos;
    }

    @Override
    public void updateUserById(int id, MallDto newUserData) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        MallDto existingMall = entityManager.find(MallDto.class,id);
        if(existingMall != null){
            existingMall.setMallName(newUserData.getMallName());
            existingMall.setMallArea(newUserData.getMallArea());
            existingMall.setNoOfFloors(newUserData.getNoOfFloors());
            existingMall.setCity(newUserData.getCity());
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
    public String getCitybyname(String name) {
        return (String) factory.createEntityManager().
createNamedQuery("getCitybyname").
                setParameter("name",name).getSingleResult();
    }

    @Override
    public int getFloorsbyName(String name) {
        return (Integer) factory.createEntityManager().
                 createNamedQuery("getFloorsbyName").
                setParameter("name",name).getSingleResult();
    }

    @Override
    public String getNameByArea(String area) {
        return (String) factory.createEntityManager().
createNamedQuery("getNameByArea").
                setParameter("area",area).getSingleResult();
    }

    @Override
    public Object[] getNameAreaFloorsByCity(String city) {
        return (Object[]) factory.createEntityManager().
createNamedQuery("getNameAreaFloorsByCity").
                setParameter("city",city).getSingleResult();
    }

    @Override
    public Object[] getCityNameByFloors(int floors) {
        return (Object[]) factory.createEntityManager().
createNamedQuery("getCityNameByFloors").
                setParameter("floor",floors).getSingleResult();
    }
}