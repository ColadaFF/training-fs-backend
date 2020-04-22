package co.edu.ff.orders.products.adapters.in.web;

import co.edu.ff.orders.common.WebAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.port.in.CreateProductUseCase;
import co.edu.ff.orders.products.application.port.in.UpdateProductUseCase;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@WebAdapter
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUserCase;

    @PostMapping
    public Try<Product> createProduct(@RequestBody CreateProductUseCase.CreateProductCommand command) {
        return createProductUseCase.createProduct(command);
    }

    @PutMapping Try<Product> updateProduct(@RequestBody UpdateProductUseCase.UpdateProductCommand command) {
        return updateProductUserCase.updateProduct(command);
    }

}
