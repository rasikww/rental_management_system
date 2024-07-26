package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetail {
    private long rentalDetailId;
    private long rentalId;
    private long hardwareItemId;
    private Double totalItemCost;
    private Integer qty;
}
