package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

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
    private long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "rental_per_day")
    private Double rentalPerDay;
    @Column(name = "fine_per_day")
    private Double finePerDay;
    private boolean availability;
}