package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.Rental;
import edu.icet.demo.entity.RentalEntity;
import edu.icet.demo.repository.RentalRepository;
import edu.icet.demo.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    
    final RentalRepository repository;
    final ObjectMapper mapper;
    
    @Override
    public Boolean addRental(Rental rental) {
        Boolean isSaved = false;
        RentalEntity rentalEntity = null;
        try {
            rentalEntity = mapper.convertValue(rental, RentalEntity.class);
            repository.save(rentalEntity);
            isSaved = true;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }

    @Override
    public List<Rental> getAll() {
        List<RentalEntity> rentalEntityList = repository.findAll();
        List<Rental> rentalList = new ArrayList<>();

        rentalEntityList.forEach(rentalEntity ->
                rentalList.add(
                        mapper.convertValue(rentalEntity, Rental.class)
                ));
        return rentalList;
    }

    @Override
    public Boolean deleteRentalById(Long id) {
        Boolean isDeleted = false;
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                isDeleted = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public Boolean updateRental(Rental rental) {
        Boolean isUpdated = false;
        try {
            if (repository.findById(rental.getRentalId()).isPresent()){
                repository.save(mapper.convertValue(rental, RentalEntity.class)
                );
                isUpdated = true;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public Rental findById(Long id) {
        return mapper.convertValue(repository.findById(id), Rental.class);
    }
}
