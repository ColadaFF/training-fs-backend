package co.edu.ff.orders.products.adapters.out.persistense;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @Column
    String description;

    @Column
    BigDecimal basePrice;

    @Column
    BigDecimal taxRate;

    @Column
    String status;

    @Column
    Integer inventoryQuantity;
}
