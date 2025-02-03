package com.xworkz.app.exception;

public class AddressNotFoundException extends RuntimeException{
        public AddressNotFoundException(String addressNotFound) {
            super(addressNotFound);
        }
}
