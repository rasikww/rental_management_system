package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareItem {
    private Long itemId;
    private String itemName;
    private Double rentalPerDay;
    private Double finePerDay;
    private boolean availability;
}
