package com.xworkz.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="distributor_sales")
@NamedQuery(name="getAllUsers",query = "from DistributorEntity distributorEntity")
public class DistributorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productCompany;
    private String productName;
    private double mrp;
    private String pack;
    private String mfgDate;
    private String expDate;
    private int quantity;
    private double rate;
    private double discount;
    private  String HSN;
    private String batchNo;
    private String createdBy;
    private LocalDate createdDate;
    private  String updatedBy;
    private  LocalDate updatedDate;
}
