package com.xworkz.app.dto;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "amazon_table")
@NamedQueries({
@NamedQuery(name = "deleteProductId",query = "delete from AmazonDto dto where id = :id"),
@NamedQuery(name = "getAllDetails",query = "select user from AmazonDto user"),
@NamedQuery(name = "getNameByPrice",query = "select user.productName from AmazonDto user where user.productPrice =: price"),
@NamedQuery(name = "getBrandNameByid",query = "select user.productName, user.brand from AmazonDto user where user.id =: id"),
@NamedQuery(name = "getColorQuantityByName",query = "select user.color, user.quantity from AmazonDto user where user.productName =: name"),
@NamedQuery(name = "getPriceByQuantity",query = "select user.productPrice from AmazonDto user where user.quantity =: quantity"),
@NamedQuery(name = "getNameByBrand",query = "select user.productName from AmazonDto user where user.brand =: brand")
})
public class AmazonDto {

    @Id
    @GenericGenerator(name = "id",strategy = "increment")
    @GeneratedValue(generator = "id")
    @Column(name = "id")
    private int id;
    @Column(name = "product_Name")
    private String productName;
    @Column(name = "brand")
    private String brand;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "color")
    private String color;
    @Column(name = "quantity")
    private int quantity;
}
