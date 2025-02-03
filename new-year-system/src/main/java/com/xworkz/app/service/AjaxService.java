package com.xworkz.app.service;

public interface AjaxService {

    String checkEmail(String email);
  //  String checkContact(long contact);

    String sendOtp(String email);
}
