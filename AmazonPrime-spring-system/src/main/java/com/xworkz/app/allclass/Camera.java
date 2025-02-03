package com.xworkz.app.allclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString

public class Camera {
    public String brand;
    public String model;
    public double resolution;
    public double price;
}
