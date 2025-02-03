package com.xworkz.app.service;

import com.xworkz.app.dao.AppDao;
import com.xworkz.app.dto.AppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppServiceImpl implements  AppService{

       @Autowired
        public AppDao appDao;
    public boolean validateAndAddApp(AppDto appDto) {
        boolean isAppNameValidated=false;
        boolean isAppAdded=false;
        if(appDto!=null){
            if(appDto.getAppName()!=null && !appDto.getAppVersion().isEmpty()){
                isAppNameValidated=true;
            }
            if(isAppNameValidated==true){
                isAppAdded=appDao.addApp(appDto);
            }
        }
        return isAppAdded;
    }

    public AppDto validateAndGetDetailsById(int id) {
        return appDao.getDetailsById(id);
    }

    public boolean validateAndUpdateAppNameById(String name, int id) {
        return appDao.updateAppNameById(name,id);
    }

    public boolean validateAndDeleteApp(int id) {
        return appDao.deleteApp(id);
    }

    public String validateAndGetAppDownloadSizeById(int id) {
        return appDao.getAppDownloadSizeById(id);
    }

    public String validateAndGetAppVersionByName(String name) {
        return appDao.getAppVersionByName(name);
    }

    public Object[] validateAndGetAppNameAndFounderNameById(int id) {
        return appDao.getAppNameAndFounderNameById(id);
    }

    public String validateAndGetAppVersionById(int id) {
        return appDao.getAppVersionById(id);
    }

    public String validateAndGetAppReleasedOnById(int id) {
        return appDao.getAppReleasedOnById(id);
    }

    public Object[] validateAndGetAppReleasedOnAndDownloadSizeByAppName(String name) {
        return appDao.getAppReleasedOnAndDownloadSizeByAppName(name);
    }

    public String validateAndGetAppNameByFounderName(String name) {
        return appDao.getAppNameByFounderName(name);
    }

    public String validateAndGetAppFounderNameByAppName(String name) {
        return appDao.getAppFounderNameByAppName(name);
    }
}
