package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rental_detail")
@SoftDelete
public class RentalDetailEntity {
    @Id
    @Column(name = "rental_detail_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rental_detail_id_generator"
    )
    @SequenceGenerator(
            name = "rental_detail_id_generator",
            allocationSize = 1
    )
    private long rentalDetailId;
    @Column(name = "rental_id")
    private long rentalId;
    @Column(name = "item_id")
    private long itemId;
    @Column(name = "total_item_cost")
    private Double totalItemCost;
    private Integer qty;
}
