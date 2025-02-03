package com.xworkz.app.allclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@ToString

@Component
public class CurrentBill {
    public String consumerName;
    public int consumerNumber;
    public double unitsConsumed;
    public double ratePerUnit;
    public double totalBill;
}
