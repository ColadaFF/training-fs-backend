package co.edu.ff.orders.products.adapters.in.web;

import co.edu.ff.orders.common.WebAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.port.in.CreateProductUseCase;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public Try<Product> createProduct(@RequestBody CreateProductUseCase.CreateProductCommand command) {
        return createProductUseCase.createProduct(command);
    }

}
