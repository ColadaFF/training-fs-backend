package co.edu.ff.orders.products.application.service;

import co.edu.ff.orders.common.UseCase;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import co.edu.ff.orders.products.application.port.in.CreateProductUseCase;
import co.edu.ff.orders.products.application.port.out.CreateProductPort;
import co.edu.ff.orders.products.application.port.out.IndexProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

@UseCase
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;
    private final IndexProductPort indexProductPort;

    @Override
    public Try<Product> createProduct(CreateProductCommand command) {
        ProductNotCreated product = command.getProduct();
        return createProductPort.createProduct(product)
                .flatMap(indexProductPort::indexProduct);
    }

    @Override
    public Try<Boolean> userHasPermission(UserDetails principal) {
        return Try.success(true);
    }
}
