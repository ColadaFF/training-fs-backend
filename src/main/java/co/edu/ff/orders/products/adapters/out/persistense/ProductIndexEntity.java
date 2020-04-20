package co.edu.ff.orders.products.adapters.out.persistense;

import lombok.Value;

@Value(staticConstructor = "of")
public class ProductIndexEntity {
    String name;
    String description;
}
