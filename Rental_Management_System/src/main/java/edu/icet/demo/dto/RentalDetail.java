package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetail {
    private Long rentalDetailId;
    private Long rentalId;
    private Long hardwareItemId;
    private Double totalItemCost;
    private Integer qty;
}
