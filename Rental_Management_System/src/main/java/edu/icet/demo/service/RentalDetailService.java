package edu.icet.demo.service;

import edu.icet.demo.dto.RentalDetail;

import java.util.List;

public interface RentalDetailService {
    Boolean addRentalDetail(RentalDetail rentalDetail);

    List<RentalDetail> getAll();

    Boolean deleteRentalDetailById(Long id);

    Boolean updateRentalDetail(RentalDetail rentalDetail);

    RentalDetail findById(Long id);
}
