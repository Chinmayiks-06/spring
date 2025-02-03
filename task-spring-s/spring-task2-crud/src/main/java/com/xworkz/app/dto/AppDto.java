package com.xworkz.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_details")
@Component
public class AppDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private int appId;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "app_download_size")
    private String downloadSize;
    @Column(name = "app_varsion")
    private String appVersion;
    @Column(name = "app_released_on")
    private String releasedOn;
    @Column(name = "app_founder_name")
    private String founderName;
}
