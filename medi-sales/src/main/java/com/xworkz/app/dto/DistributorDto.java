package com.xworkz.app.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DistributorDto {

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
