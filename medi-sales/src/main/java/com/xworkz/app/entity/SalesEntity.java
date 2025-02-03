package com.xworkz.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@ToString
@Table(name = "medisales_details")
@NamedQuery(name = "checkEmailToLogin",query ="select user from SalesEntity user where user.regEmail=:em")
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "business_type")
    private String businessType;
    @Column(name = "mobile_num")
    private Long regNumber;
    @Column(name = "email")
    private String regEmail;
    @Column(name = "address_one")
    private String addressOne;
    @Column(name = "address_two")
    private String addressSecond;
    @Column(name = "pincode")
    private Integer pincode;
    @Column(name = "referral")
    private String referral;
    @Column(name = "password")
    private String password;
    @Column(name = "confirm_password")
    private String confirmPassword;
    @Column(name = "created_By")
    private String createdBy;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "updated_By")
    private String updatedBy;
    @Column(name = "updateddate")
    private LocalDate updatedDate;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "contentType")
    private String  contentType;
    @Column(name = "attempt")
    private Integer attempt;
    @Column(name = "otp")
    private String otp;


}
