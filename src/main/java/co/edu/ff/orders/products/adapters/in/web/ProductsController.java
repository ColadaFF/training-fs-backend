package co.edu.ff.orders.products.adapters.in.web;

import co.edu.ff.orders.common.WebAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import co.edu.ff.orders.products.application.port.in.CreateProductUseCase;
import co.edu.ff.orders.products.application.port.in.UpdateProductUseCase;
import co.edu.ff.orders.products.application.port.in.UploadProductImageUseCase;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@WebAdapter
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUserCase;
    private final UploadProductImageUseCase uploadProductImageUseCase;

    @PostMapping
    public Try<Product> createProduct(@RequestBody CreateProductUseCase.CreateProductCommand command, Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return createProductUseCase.userHasPermission(principal)
                .flatMap(permission -> createProductUseCase.createProduct(command));
    }

    @PutMapping
    Try<Product> updateProduct(@RequestBody UpdateProductUseCase.UpdateProductCommand command) {
        return updateProductUserCase.updateProduct(command);
    }

    @PostMapping("/images")
    Try<Object> uploadProductImage(@RequestParam("file") MultipartFile file, @RequestParam("id") Long productId) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        ProductId id = ProductId.of(productId);
        UploadProductImageUseCase.UploadProductImageCommand command = UploadProductImageUseCase.UploadProductImageCommand.of(
                id,
                file.getInputStream(),
                file.getSize(),
                file.getContentType(),
                extension
        );
        return uploadProductImageUseCase.hasPermission()
                .filter(hasPermission -> hasPermission)
                .flatMap(hasPermission -> uploadProductImageUseCase.process(command));
    }

}
