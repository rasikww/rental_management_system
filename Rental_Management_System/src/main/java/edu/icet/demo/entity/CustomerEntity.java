package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
@SoftDelete
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )
    @SequenceGenerator(
            name = "customer_id_generator",
            allocationSize = 1
    )
    private long customerId;
    @Column(name = "customer_name")
    private String customerName;
    private String contact;
    private String city;
    @OneToMany(mappedBy = "customerId")
    private List<RentalEntity> rentalEntityList;
}
