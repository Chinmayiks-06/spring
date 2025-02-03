package com.xworkz.app.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_details")
@NamedQuery(name = "getAllDetails",query = "from UserDto")
public class UserDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private  String userName;
    @Column(name = "user_emailId")
    private  String emailId;
    @Column(name = "pass")
    private  String password;
    @Column(name = "confirmPassword")
    private String confirmPassword;
}
