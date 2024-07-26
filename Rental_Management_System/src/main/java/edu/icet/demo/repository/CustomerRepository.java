package edu.icet.demo.repository;

import edu.icet.demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
