package com.xworkz.app.dao;

import com.xworkz.app.dto.AppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Component
public class AppDaoImpl implements AppDao{

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public boolean addApp(AppDto appDto) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(appDto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    @Override
    public AppDto getDetailsById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
      AppDto appDto = entityManager.find(AppDto.class,id);
        return appDto;
    }
    @Override
    public boolean updateAppNameById(String name, int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Query query =entityManager.createNamedQuery("updateAppNameById");
        query.setParameter("name",name);
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }
    @Override
    public boolean deleteApp(int id) {
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("deleteApp");
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }
    @Override
    public String getAppDownloadSizeById(int id) {
        return (String) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppDownloadSizeById").
                setParameter("id",id).getSingleResult();

    }
    @Override
    public String getAppVersionByName(String name) {
        return (String) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppVersionByName").
                setParameter("name",name).getSingleResult();

    }
    @Override
    public Object[] getAppNameAndFounderNameById(int id) {
        return (Object[]) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppNameAndFounderNameById").
                setParameter("id",id).getSingleResult();
    }
    @Override
    public String getAppVersionById(int id) {
        return (String) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppVersionById").
                setParameter("id",id).getSingleResult();

    }
    @Override
    public String getAppReleasedOnById(int id) {
        return (String) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppReleasedOnById").
                setParameter("id",id).getSingleResult();
    }
    @Override
    public Object[] getAppReleasedOnAndDownloadSizeByAppName(String name) {
        return (Object[]) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppReleasedOnAndDownloadSizeByAppName").
                setParameter("name",name).getSingleResult();
    }
    @Override
    public String getAppNameByFounderName(String name) {
        return (String) entityManagerFactory.createEntityManager().
                createNamedQuery("getAppNameByFounderName").
                setParameter("name",name).getSingleResult();
    }
    @Override
    public String getAppFounderNameByAppName(String name) {
      return (String) entityManagerFactory.createEntityManager().
              createNamedQuery("getAppFounderNameByAppName").
              setParameter("name",name).getSingleResult();
    }
}
