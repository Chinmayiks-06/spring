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
@Table(name = "patient_detailss")
@Component
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
