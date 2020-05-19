package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.*;
import io.vavr.control.Try;
import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public interface CreateProductUseCase {

    Try<Product> createProduct(CreateProductCommand command);

    Try<Boolean> userHasPermission(UserDetails principal);

    @Value(staticConstructor = "of")
    class CreateProductCommand {
        ProductNotCreated product;
    }
}
