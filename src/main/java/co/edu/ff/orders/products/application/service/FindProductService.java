package co.edu.ff.orders.products.application.service;

import co.edu.ff.orders.common.UseCase;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.port.in.FindProductUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class FindProductService implements FindProductUseCase {
    @Override
    public Optional<Product> findProduct(FindProductQuery query) {
        return Optional.empty();
    }
}
