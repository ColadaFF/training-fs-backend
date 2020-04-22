package co.edu.ff.orders.products.application.port.out;

import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;

public interface UpdateProductPort {
    Try<Product> updateProduct(ProductId id, ProductNotCreated product);
}
