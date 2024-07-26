package edu.icet.demo.repository;

import edu.icet.demo.entity.HardwareItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareItemRepository extends JpaRepository<HardwareItemEntity, Long> {
}
