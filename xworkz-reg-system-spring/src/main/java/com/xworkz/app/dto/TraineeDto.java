package com.xworkz.app.dto;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "trainee_details")
public class TraineeDto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int traineeId;
    @Column(name = "trainee_name")
    private String traineeName;
    @Column(name = "trainee_email")
    private String traineeEmail;
    @Column(name = "phone_no")
    private long phoneNum;
    @Column(name = "address")
    private String address;
    @Column(name = "stream_name")
    private String streamName;

}
