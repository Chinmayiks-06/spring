package com.xworkz.app.dto;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_details")
@NamedQueries({
        @NamedQuery(name ="getNameById",query = "select user.userName from UserDto user where user.id =:ref"),
        @NamedQuery(name = "editAddressByPhoneNumber",query = "update UserDto dto set dto.address =:add where dto.phNo=:phoneNo")
})
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;
    @Column(name="name")
    private String userName;
    @Column(name="phNo")
    private long phNo;
    @Column(name="address")
    private String address;


}
