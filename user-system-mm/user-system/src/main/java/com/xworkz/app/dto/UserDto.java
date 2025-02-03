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
        @NamedQuery(name="getUserNameByPhNo",query="select user.userName, user.phNo from UserDto user where user.userId=:i"),
        @NamedQuery(name="getUserNameAndAddressById",query=" select user.userName, user.address from UserDto user where user.userId=:ref"),
        @NamedQuery(name = "getAddressById",query = "select user.address from UserDto user where user.userId=:i"),
        @NamedQuery(name = "getPhNoById",query = "select user.phNo from UserDto user where user.userId=:i"),
        @NamedQuery(name = "getUserNameById",query = "select user.userName from UserDto user where user.userId=:i"),
        @NamedQuery(name = "getUserNameAndAddressByPhNo",query = "select user.userName, user.address from UserDto user where user.phNo=:pn"),


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
