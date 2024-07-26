package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hardware_item")
@SoftDelete
public class HardwareItemEntity {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_generator"
    )
    @SequenceGenerator(
            name = "item_id_generator",
            allocationSize = 1
    )
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "rental_per_day")
    private Double rentalPerDay;
    @Column(name = "fine_per_day")
    private Double finePerDay;
    private boolean availability;
    @OneToMany(mappedBy = "hardwareItemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalDetailEntity> rentalDetailEntityList;
}
