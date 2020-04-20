package co.edu.ff.orders.products.application.port.out;

import co.edu.ff.orders.products.application.domain.Product;
import io.vavr.control.Try;

public interface IndexProductPort {

    Try<Product> indexProduct(Product product);
}
