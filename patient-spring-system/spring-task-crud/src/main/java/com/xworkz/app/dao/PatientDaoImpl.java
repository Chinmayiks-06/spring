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

    public PatientDto getPatientById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PatientDto patientDto=entityManager.find(PatientDto.class,id);
        return patientDto;
    }

    public boolean updatePatientNameById(String patientName, int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query =entityManager.createQuery("update PatientDto set userName=:name where id=:id ");
        query.setParameter("name",patientName);
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        return true;
    }

    public boolean deletePatient(int id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      Query query =entityManager.createQuery("delete from PatientDto where id=:id");
      query.setParameter("id",id);
      query.executeUpdate();
      entityManager.getTransaction().commit();
        return true;
    }

    public String getPatientNameById(int id) {

        try {

            return (String) entityManagerFactory.createEntityManager().
                    createQuery("select patient.patientName from PatientDto patient where patient.id=:id").
                    setParameter("id",id).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }

    public String getPatientLastNameById(int id) {

        try {

            return(String) entityManagerFactory.createEntityManager().
                    createQuery("select patient.patientLastname from PatientDto patient where patient.patientId=:id").
                    setParameter("id",id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Object[] getPatientNameAndPhoneNumberById(int id) {
       return(Object[]) entityManagerFactory.createEntityManager().
                createQuery("select patient.patientName , patient.patientPhoneNo from PatientDto patient where patient.patientId=:id").
                setParameter("id",id).getSingleResult();

    }

    public String getPatientNameByAge(int id) {
       return(String) entityManagerFactory.createEntityManager().
                createQuery("select patient.patientName from PatientDto patient where patient.patientId=:id").
                setParameter("id",id).getSingleResult();

    }

    public int getPatientAgeByName(String name) {
        return(Integer) entityManagerFactory.createEntityManager().
                createQuery("select patient.patientAge from PatientDto patient where patient.patientName=:name").
                setParameter("name",name).getSingleResult();
    }

    public Object[] getPatientPhoneNoAndAddressById(int id) {
        return new Object[0];
    }
}
