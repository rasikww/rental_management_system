package edu.icet.demo.repository;

import edu.icet.demo.entity.RentalDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDetailRepository extends JpaRepository<RentalDetailEntity, Long> {
}
