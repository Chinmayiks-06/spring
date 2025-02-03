package com.xworkz.app.constant;

import lombok.Getter;

@Getter
public enum ServiceConstant {

    FILE_PATH("D://new-year-files/"),FROM_EMAIL("chinmayiks06.xworkz@gmail.com"),FROM_NAME("Chinmayi"),password("hxgz htuo nrna nthr");

    private String path;

    private ServiceConstant(String path){
        this.path=path;
    }

}
