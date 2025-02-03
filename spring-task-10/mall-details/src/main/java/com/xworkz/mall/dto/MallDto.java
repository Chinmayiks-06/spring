package com.xworkz.mall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "mall_details")
@NamedQueries({
@NamedQuery(name = "getAllDetails",query="select user from MallDto user"),
@NamedQuery(name = "DeleteUserById",query="delete from MallDto dto where dto.id =: id"),
@NamedQuery(name = "getCitybyname",query="select user.city from MallDto user where user.mallName =: name"),
@NamedQuery(name = "getFloorsbyName",query="select user.noOfFloors from MallDto user where user.mallName =: name"),
@NamedQuery(name = "getNameByArea",query="select user.mallName from MallDto user where user.mallArea =: area"),
@NamedQuery(name = "getNameAreaFloorsByCity",query="select user.mallName, user.noOfFloors, user.mallArea from MallDto user where user.city =: city"),
@NamedQuery(name = "getCityNameByFloors",query="select user.mallName, user.city from MallDto user where user.noOfFloors =: floor")
})
public class MallDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mall_id")
    private int id;
    @Column(name = "mall_name")
    private String mallName;
    @Column(name = "mall_area")
    private String mallArea;
    @Column(name = "mall_noOfFloors")
    private int noOfFloors;
    @Column(name = "mall_city")
    private String city;
}
