package com.xworkz.app.service;

import com.xworkz.app.dao.PatientDao;
import com.xworkz.app.dto.PatientDto;
import com.xworkz.app.exception.LastNameNotFoundException;
import com.xworkz.app.exception.NameNotFoundException;
import com.xworkz.app.exception.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceImpl implements  PatientService{
    @Autowired
    public PatientDao patientDao;
    public boolean addPatient(PatientDto patientDto) {
        boolean isPatientAdded=false;
        boolean isPatientNameAdded=false;
        if(patientDto!=null){
            if(patientDto.getPatientName()!=null && !patientDto.getPatientName().isEmpty()){
                isPatientNameAdded=true;
            }
            if(isPatientNameAdded==true){
              isPatientAdded= patientDao.addPatient(patientDto);
            }
        }
        return isPatientAdded;
    }

    @Override
    public PatientDto getPatientById(int id) {
        return   patientDao.getPatientById(id);
    }
    @Override
    public boolean updatePatientNameById(String patientName, int id) {
       boolean isPatientNameUpdated= false;

       if(id > 0){
           if(patientName!=null){
               isPatientNameUpdated=patientDao.updatePatientNameById(patientName,id);
           }
       }
        return isPatientNameUpdated;
    }
    @Override
    public boolean deletePatient(int id) {
        boolean isPatientDeleted=false;
        if(id > 0){
            isPatientDeleted=patientDao.deletePatient(id);
        }

        return isPatientDeleted;
    }
    @Override
    public String getPatientNameById(int id) {
        String name=null;
        if(id > 0){
            name=patientDao.getPatientNameById(id);
        }
        if(name==null){
            throw  new NameNotFoundException("name not found for id ="+id);
        }
        return name;
    }
    @Override
    public String getPatientLastNameById(int id) {
        String lastName=null;
        if(id > 0){
          lastName = patientDao.getPatientLastNameById(id);
        }
        if(lastName==null){
            throw new LastNameNotFoundException("Last name Not Found for id="+id);
        }
        return lastName;
    }
    @Override
    public Object[] getPatientNameAndPhoneNumberById(int id) {
         return patientDao.getPatientNameAndPhoneNumberById(id);
    }
    @Override
    public String getPatientNameByAge(int id) {
        return patientDao.getPatientNameByAge(id);
    }
    @Override
    public int getPatientAgeByName(String name) {
        return patientDao.getPatientAgeByName(name);
    }
    @Override
    public Object[] getPatientPhoneNoAndAddressById(int id) {
        return patientDao.getPatientPhoneNoAndAddressById(id);
    }
}
