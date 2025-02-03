package com.xworkz.app.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hp_user")
@NamedQueries({
        @NamedQuery(name = "getNameAndSerialNoByEmail",query = "select user.firstName, user.serialNumber from HpDto user where user.email =: email"),
        @NamedQuery(name = "getSerialNoById",query = "select user.serialNumber from HpDto user where user.id=: i"),
        @NamedQuery(name = "getEmailBySerialNo",query = "select user.email from HpDto user where user.serialNumber=: s"),
        @NamedQuery(name = "getEmailById",query = "select user.email from HpDto user where user.id=:i"),
        @NamedQuery(name = "getNameBySerialNo",query = "select user.firstName from HpDto user where user.serialNumber=:s"),
        @NamedQuery(name = "getPasswordByEmail",query = "select user.password from HpDto user where user.email=:e"),
        @NamedQuery(name = "updatePasswordByEmail",query = "update HpDto dto set dto.password=:pass where dto.email=:e"),
        @NamedQuery(name = "updatePasswordByEmail",query = "update HpDto dto set dto.password=:pass where dto.email=:e"),
        @NamedQuery(name = "deleteUserBySerialNo",query = "delete HpDto dto from dto.serialNumber=:s"),
        @NamedQuery(name = "deleteUserByName",query = "delete HpDto dto from dto.firstName=:f"),
})
public class HpDto {
    @Id
    @GenericGenerator(name = "ref",strategy = "increment")
    @GeneratedValue(generator = "ref")

    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private  String password;
}

