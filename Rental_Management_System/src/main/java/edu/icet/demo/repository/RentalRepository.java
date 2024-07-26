package edu.icet.demo.repository;

import edu.icet.demo.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
}
