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
@NamedQueries({@NamedQuery(name = "updateAppNameById",query = "update AppDto set appName=:name where id=:id"),
        @NamedQuery(name = "deleteApp",query = "delete from AppDto where id=:id"),
        @NamedQuery(name = "getAppDownloadSizeById",query = "select app.downloadSize from AppDto app where app.appId=:id"),
        @NamedQuery(name = "getAppVersionByName",query = "select app.appVersion from AppDto app where app.appName=:name"),
        @NamedQuery(name = "getAppNameAndFounderNameById",query = "select app.appName , app.founderName from AppDto app where app.appId=:id"),
        @NamedQuery(name = "getAppVersionById",query = "select app.appVersion from AppDto app where app.appId=:id"),
        @NamedQuery(name = "getAppReleasedOnById",query = "select app.releasedOn from AppDto app where app.appId=:id"),
        @NamedQuery(name = "getAppReleasedOnAndDownloadSizeByAppName",query = "select app.releasedOn, app.downloadSize from AppDto app where app.appName=:name"),
        @NamedQuery(name = "getAppNameByFounderName",query = "select app.appName from AppDto app where app.founderName=:name"),
        @NamedQuery(name = "getAppFounderNameByAppName",query = "select app.founderName from AppDto app where app.appName=:name")})
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
