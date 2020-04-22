package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.Product;

import java.util.List;

public interface FindProductsUseCase {
    List<Product> findProduct();
}
