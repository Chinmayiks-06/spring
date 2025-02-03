package com.xworkz.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@ToString
@Table(name = "user_details")
@NamedQueries({
        @NamedQuery(name = "checkEmailAndPassword", query = "select user from UserEntity user where user.email=:em"),
        @NamedQuery(name = "checkEmail", query = "select count(email) from UserEntity user where user.email=:em"),
        @NamedQuery(name = "checkContact", query = "select count(contact) from UserEntity user where user.contact=:cc")
})

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "alterEmail")
    private String alterEmail;
    @Column(name = "contact")
    private Long contact;
    @Column(name = "alterContact")
    private Long alterContact;
    @Column(name = "dob")
    private String dob;
    @Column(name = "place")
    private String place;
    @Column(name = "state")
    private String state;
    @Column(name = "district")
    private String district;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "confirmPassword")
    private String confirmPassword;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "updatedBy")
    private String updatedBy;
    @Column(name = "updateDate")
    private LocalDate updateDate;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "attempt")
    private Integer attempt;
    private String otp;

}
 