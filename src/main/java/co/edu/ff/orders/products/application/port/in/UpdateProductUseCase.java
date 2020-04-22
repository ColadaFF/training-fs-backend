package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;
import lombok.Value;

public interface UpdateProductUseCase {

    Try<Product> updateProduct(UpdateProductCommand command);

    @Value
    class UpdateProductCommand {
        ProductId id;
        ProductNotCreated product;
    }
}
