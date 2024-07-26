package edu.icet.demo.service;

import edu.icet.demo.dto.Rental;

import java.util.List;

public interface RentalService {
    Boolean addRental(Rental rental);

    List<Rental> getAll();

    Boolean deleteRentalById(Long id);

    Boolean updateRental(Rental rental);

    Rental findById(Long id);
}
