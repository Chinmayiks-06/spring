package com.xworkz.app.service;

import com.xworkz.app.dto.PatientDto;

public interface PatientService {

    boolean addPatient(PatientDto patientDto);

    PatientDto getPatientById(int id);

    boolean updatePatientNameById(String patientName , int id);

    boolean deletePatient(int id);

    String getPatientNameById( int id);

    String getPatientLastNameById( int id);

    Object[] getPatientNameAndPhoneNumberById(int id);

    String getPatientNameByAge(int id);

    int getPatientAgeByName(String name);
    Object[] getPatientPhoneNoAndAddressById(int id);
}
