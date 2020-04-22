package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import io.vavr.control.Try;
import lombok.Value;

public interface DeleteProductUseCase {
    Try<Product> deleteProduct(DeleteProductCommand command);

    @Value
    class DeleteProductCommand {
        ProductId id;
    }
}
