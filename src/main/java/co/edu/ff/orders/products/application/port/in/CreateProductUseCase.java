package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.*;
import io.vavr.control.Try;
import lombok.Value;

public interface CreateProductUseCase {

    Try<Product> createProduct(CreateProductCommand command);

    @Value(staticConstructor = "of")
    class CreateProductCommand {
        ProductNotCreated product;
    }
}
