package com.xworkz.app.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "patient_details")
@NamedQueries({
              @NamedQuery(name = "updatePatientNameById" , query = "update PatientDto set patientName=:name where patientId=:id"),
              @NamedQuery(name = "deletePatient",query = "delete from PatientDto where id=:id"),
              @NamedQuery(name ="getPatientNameById" ,query = "select patient.patientName from PatientDto patient where patient.id=:id"),
              @NamedQuery(name = "getPatientLastNameById",query = "select patient.patientLastname from PatientDto patient where patient.patientId=:id"),
              @NamedQuery(name = "getPatientNameAndPhoneNumberById",query = "select patient.patientName , patient.patientPhoneNo from PatientDto patient where patient.patientId=:id"),
              @NamedQuery(name = "getPatientNameByAge",query = "select patient.patientName from PatientDto patient where patient.patientAge=:age"),
              @NamedQuery(name = "getPatientAgeByName",query = "select patient.patientAge from PatientDto patient where patient.patientName=:name"),
              @NamedQuery(name = "getPatientPhoneNoAndAddressById",query = "select patient.patientPhoneNo from PatientDto patient where patient.patientId=:id")
            })
public class PatientDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_last_name")
    private String patientLastname;
    @Column(name = "patient_phone_no")
    private long patientPhoneNo;
    @Column(name = "patient_age")
    private int patientAge;
    @Column(name = "patient_address")
    private String patientAddress;
}
