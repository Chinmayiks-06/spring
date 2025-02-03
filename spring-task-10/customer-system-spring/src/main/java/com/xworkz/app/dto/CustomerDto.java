package com.xworkz.app.dto;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer_details")
@NamedQueries({
@NamedQuery(name = "getAllDetails",query = "select user from CustomerDto user"),
@NamedQuery(name = "DeleteUserById",query = "delete from CustomerDto dto where dto.id =: id"),
@NamedQuery(name = "getNameByNo",query = "select user.customerName from CustomerDto user where user.customerNo =: no"),
@NamedQuery(name = "getEmailByNo",query = "select user.Email from CustomerDto user where user.customerNo =: no"),
@NamedQuery(name = "getNoAndNameByEmail",query = "select user.customerNo, user.customerName from CustomerDto user where user.Email =: email"),
@NamedQuery(name = "updateNoByName",query = "update CustomerDto dto set dto.customerNo =: no where dto.customerName =: name"),
@NamedQuery(name = "deleteCustomerByEmail",query = "delete from CustomerDto dto where dto.Email =: email")
})
public class CustomerDto {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id",strategy = "increment")
    @GeneratedValue(generator = "id")
    @Column(name = "customer_id")
    private  int id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email")
    private String Email;
    @Column(name = "customer_number")
    private  int customerNo;
}
