package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import lombok.Value;

import java.util.Optional;

public interface FindProductUseCase {
    Optional<Product> findProduct(FindProductQuery query);

    @Value
    class FindProductQuery {
        ProductId productId;
    }
}
