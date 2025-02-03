package com.xworkz.app.allclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Metro {
    public String lineName;
    public String startStation;
    public String endStation;
    public int numberOfStops;
}