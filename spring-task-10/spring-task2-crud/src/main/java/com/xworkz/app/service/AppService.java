package com.xworkz.app.service;

import com.xworkz.app.dto.AppDto;

public interface AppService {

    boolean validateAndAddApp(AppDto appDto);
    AppDto validateAndGetDetailsById(int id);

    boolean validateAndUpdateAppNameById(String name, int id);
    boolean validateAndDeleteApp(int id);

    String  validateAndGetAppDownloadSizeById(int id);

    String validateAndGetAppVersionByName(String name);

    Object[] validateAndGetAppNameAndFounderNameById(int id);
    String validateAndGetAppVersionById(int id);

    String validateAndGetAppReleasedOnById(int id);

    Object[] validateAndGetAppReleasedOnAndDownloadSizeByAppName(String name);
    String validateAndGetAppNameByFounderName(String name);

    String validateAndGetAppFounderNameByAppName(String name);
}
