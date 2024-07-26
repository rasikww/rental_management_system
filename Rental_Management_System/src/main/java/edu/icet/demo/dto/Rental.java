package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    private Long rentalId;
    private Long customerId;
    private LocalDate rentalDate;
    private LocalDate expectedReturnDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Double fine;
    private Double totalCost;
}
