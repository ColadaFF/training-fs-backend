package co.edu.ff.orders.products.application.port.out;

import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import io.vavr.control.Try;

public interface CreateProductPort {

    Try<Product> createProduct(ProductNotCreated product);
}
