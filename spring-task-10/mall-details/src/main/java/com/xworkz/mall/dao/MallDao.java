package com.xworkz.mall.dao;

import com.xworkz.mall.dto.MallDto;

import java.util.List;

public interface MallDao {

    boolean save(MallDto mallDto);

    MallDto getUserById(int id);

    List<MallDto> getAllDetails(MallDto mallDto);

    void updateUserById(int id, MallDto newUserData);

    boolean DeleteUserById(int id);

    String getCitybyname(String name);

    int getFloorsbyName(String name);

    String getNameByArea(String area);

    Object [] getNameAreaFloorsByCity(String city);

    Object [] getCityNameByFloors(int floors);

}
