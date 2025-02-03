package com.xworkz.app.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesDto implements Serializable {



    private int id;

    @NotNull(message = "Company name should not be null")
    @Size(min = 3, max = 50, message = "Company name must be between 3 and 50 characters")
    private String companyName;

    @NotNull(message = "Contact person should not be null")
    @Size(min = 3, max = 30, message = "Contact person name must be between 3 and 30 characters")
    private String contactPerson;

    private String businessType;

    @NotNull(message = "Mobile number should not be null")
    private Long regNumber;

    @NotNull(message = "Email should not be null")
    @Email(message = "Invalid email format")
    private String regEmail;

    @NotNull(message = "Address line one should not be null")
    private String addressOne;

    private String addressSecond;

    @NotNull(message = "Pincode should not be null")
    private Integer pincode;

    private String referral;

    @NotNull(message = "Password should not be null")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    @NotNull(message = "Confirm password should not be null")
    @Size(min = 4, message = "Confirm password must be at least 4 characters long")
    private String confirmPassword;
    private String createdBy;
    private LocalDate createdDate;
    private String updatedBy;
    private LocalDate updatedDate;
    private String fileName;
    private String  contentType;
    private Integer attempt;
    private String otp;




}
