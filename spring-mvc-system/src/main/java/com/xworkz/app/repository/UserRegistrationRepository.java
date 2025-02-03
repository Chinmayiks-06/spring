package com.xworkz.app.repository;

import com.xworkz.app.dto.UserDto;

public interface UserRegistrationRepository {

    boolean save(UserDto dto);
}
