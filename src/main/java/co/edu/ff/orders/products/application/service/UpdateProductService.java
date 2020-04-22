package co.edu.ff.orders.products.application.service;

import co.edu.ff.orders.common.UseCase;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.port.in.UpdateProductUseCase;
import co.edu.ff.orders.products.application.port.out.UpdateProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final UpdateProductPort updateProductPort;

    @Override
    public Try<Product> updateProduct(UpdateProductCommand command) {
        return updateProductPort.updateProduct(command.getId(), command.getProduct());
    }
}
