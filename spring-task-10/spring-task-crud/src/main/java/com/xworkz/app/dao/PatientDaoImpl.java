package com.xworkz.app.dao;

import com.xworkz.app.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Component
public class PatientDaoImpl implements PatientDao{
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    public boolean addPatient(PatientDto patientDto) {
     EntityManager entityManager =  entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.persist(patientDto);
     entityManager.getTransaction().commit();
     entityManager.close();
        return true;
    }

    @Override
    public PatientDto getPatientById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PatientDto patientDto=entityManager.find(PatientDto.class,id);
        return patientDto;
    }
    @Override
    public boolean updatePatientNameById(String patientName, int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createNamedQuery("updatePatientNameById");
        query.setParameter("name",patientName);
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }
    @Override
    public boolean deletePatient(int id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      Query query =entityManager.createNamedQuery("deletePatient");
      query.setParameter("id",id);
      query.executeUpdate();
      entityManager.getTransaction().commit();
        return true;
    }
    @Override
    public String getPatientNameById(int id) {

        try {

            return (String) entityManagerFactory.createEntityManager().
                    createNamedQuery("getPatientNameById").
                    setParameter("id",id).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }
    @Override
    public String getPatientLastNameById(int id) {

        try {

            return(String) entityManagerFactory.createEntityManager().
                    createNamedQuery("getPatientLastNameById").
                    setParameter("id",id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @Override
    public Object[] getPatientNameAndPhoneNumberById(int id) {
       return(Object[]) entityManagerFactory.createEntityManager().
                createNamedQuery("getPatientNameAndPhoneNumberById").
                setParameter("id",id).getSingleResult();

    }
    @Override
    public String getPatientNameByAge(int age) {
       return(String) entityManagerFactory.createEntityManager().
                createNamedQuery("getPatientNameByAge").
                setParameter("age",age).getSingleResult();

    }
    @Override
    public int getPatientAgeByName(String name) {
        return(Integer) entityManagerFactory.createEntityManager().
                createNamedQuery("getPatientAgeByName").
                setParameter("name",name).getSingleResult();
    }
    @Override
    public Object[] getPatientPhoneNoAndAddressById(int id) {
       return (Object[]) entityManagerFactory.createEntityManager().
               createNamedQuery("getPatientPhoneNoAndAddressById").
               setParameter("id",id).getSingleResult();
    }
}
