package com.xworkz.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_inf")
@NamedQueries({
        @NamedQuery(name = "updateProductPriceById",query = "update ProductDto set productPrice=:price where productId=:id "),
        @NamedQuery(name = "deleteProduct",query = "delete from ProductDto where productId=:id "),
        @NamedQuery(name = "getProductNameById",query = "select product.productName from ProductDto product where product.productId=:id"),
        @NamedQuery(name = "getProductPriceById",query = "select product.productPrice from ProductDto product where product.productId=:id"),
        @NamedQuery(name = "getProductTypeByProductName",query = "select product.productType from ProductDto product where product.productName=:name"),
        @NamedQuery(name = "getProductNameAndProductPriceById",query = "select product.productName , product.productPrice from ProductDto product where product.productId=:id"),
        @NamedQuery(name = "getProductColorAndProductTypeByProductName",query = "select product.productColor , product.productType from ProductDto product where product.productName=:name")

})
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private  int productId;
    @Column(name = "product_name")
    private  String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "product_quantity")
    private int quantity;
    @Column(name = "product_color")
    private String productColor;

}

