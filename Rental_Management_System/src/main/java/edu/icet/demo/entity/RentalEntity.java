package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rental")
@SoftDelete
public class RentalEntity {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rental_id_generator"
    )
    @SequenceGenerator(
            name = "rental_id_generator",
            allocationSize = 1
    )
    private Long rentalId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @Column(name = "rental_date")
    private LocalDate rentalDate;
    @Column(name = "expected_return_date")
    private LocalDate expectedReturnDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
    private Double fine;
    @Column(name = "total_cost")
    private Double totalCost;
    @OneToMany(mappedBy = "rentalEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalDetailEntity> rentalDetailEntityList;

}
