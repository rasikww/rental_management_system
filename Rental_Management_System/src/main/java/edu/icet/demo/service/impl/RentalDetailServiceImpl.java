package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.RentalDetail;
import edu.icet.demo.entity.RentalDetailEntity;
import edu.icet.demo.repository.RentalDetailRepository;
import edu.icet.demo.service.RentalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalDetailServiceImpl implements RentalDetailService {
    
    final RentalDetailRepository repository;
    final ObjectMapper mapper;
    
    @Override
    public Boolean addRentalDetail(RentalDetail rentalDetail) {
        Boolean isSaved = false;
        RentalDetailEntity rentalDetailEntity = null;
        try {
            rentalDetailEntity = mapper.convertValue(rentalDetail, RentalDetailEntity.class);
            repository.save(rentalDetailEntity);
            isSaved = true;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }

    @Override
    public List<RentalDetail> getAll() {
        List<RentalDetailEntity> rentalDetailEntityList = repository.findAll();
        List<RentalDetail> rentalDetailList = new ArrayList<>();

        rentalDetailEntityList.forEach(rentalDetailEntity ->
                rentalDetailList.add(
                        mapper.convertValue(rentalDetailEntity, RentalDetail.class)
                ));
        return rentalDetailList;
    }

    @Override
    public Boolean deleteRentalDetailById(Long id) {
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
    public Boolean updateRentalDetail(RentalDetail rentalDetail) {
        Boolean isUpdated = false;
        try {
            if (repository.findById(rentalDetail.getRentalDetailId()).isPresent()){
                repository.save(mapper.convertValue(rentalDetail, RentalDetailEntity.class)
                );
                isUpdated = true;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public RentalDetail findById(Long id) {
        return mapper.convertValue(repository.findById(id), RentalDetail.class);
    }
}
