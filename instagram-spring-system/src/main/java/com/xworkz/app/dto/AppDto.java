package com.xworkz.app.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="login_detailss")
public class AppDto {
    @Id
    @GenericGenerator(name = "ref",strategy = "increment")
    @GeneratedValue(generator="ref")
    @Column(name="user_id")
    private int id;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_email")
    private String email;
    @Column(name="u_password")
    private String password;
    @Column(name="confirm_password")
    private String  confPassword;


}
