package com.xworkz.app.constant;

import lombok.Getter;

@Getter
public enum MessageConstant {

    OTP_VALIDATE_MESSAGE("valid otp"),OTP_VALIDATE_REJECT_MESSAGE("Invalid otp");
    private String message;

    private MessageConstant(String message){
        this.message=message;
    }
}
