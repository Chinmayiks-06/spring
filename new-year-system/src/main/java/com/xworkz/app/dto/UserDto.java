package com.xworkz.app.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto  {

    private Integer id;
    @NotNull(message = "First name should not be null")
    @Size(min = 3,max =30,message = "name must be min 3 character max 30")
    private String firstName;
    @NotNull(message = "last name should not be null")
    @Size(min = 2,max = 10,message = "last name must be min 2 character")
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String alterEmail;
    private Long contact;
    private Long alterContact;
    private String dob;
    private String place;
    private String state;
    private String district;
    private String userPassword;
    private String confirmPassword;
    private String createdBy;
    private LocalDate createdDate;
    private String updatedBy;
    private LocalDate updateDate;
    private String fileName;
    private String contentType;
    private Integer attempt;
    private String otp;
}
