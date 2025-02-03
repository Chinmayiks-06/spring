package com.xworkz.app.dao;

import com.xworkz.app.dto.AppDto;

public interface AppDao {

    boolean addApp(AppDto appDto);
    AppDto getDetailsById(int id);

    boolean updateAppNameById(String name, int id);
    boolean deleteApp(int id);

    String  getAppDownloadSizeById(int id);

   String getAppVersionByName(String name);

   Object[] getAppNameAndFounderNameById(int id);
    String getAppVersionById(int id);

    String getAppReleasedOnById(int id);

     Object[] getAppReleasedOnAndDownloadSizeByAppName(String name);
     String getAppNameByFounderName(String name);

       String getAppFounderNameByAppName(String name);


}
