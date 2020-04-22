package co.edu.ff.orders.products.adapters.out.persistense;

import co.edu.ff.orders.common.PersistenceAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductId;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import co.edu.ff.orders.products.application.port.out.CreateProductPort;
import co.edu.ff.orders.products.application.port.out.UpdateProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class ProductPersistenceAdapter implements CreateProductPort, UpdateProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public Try<Product> createProduct(ProductNotCreated product) {
        return Try.of(() -> {
            ProductJpaEntity productJpaEntity = productMapper.mapToJpaEntity(product);
            ProductJpaEntity createdProduct = productRepository.save(productJpaEntity);
            return productMapper.mapToDomainEntity(createdProduct);
        });
    }

    @Override
    public Try<Product> updateProduct(ProductId productId, ProductNotCreated product) {
        return Try.of(() -> {
            Long id = productId.getValue();
            Optional<ProductJpaEntity> currentProductOptional = productRepository.findById(id);
            ProductJpaEntity updateEntity = productMapper.mapToJpaEntity(product);
            return currentProductOptional
                    .map(productJpaEntity -> {
                        productJpaEntity.setName(updateEntity.getName());
                        productJpaEntity.setDescription(updateEntity.getDescription());
                        productJpaEntity.setBasePrice(updateEntity.getBasePrice());
                        productJpaEntity.setTaxRate(updateEntity.getTaxRate());
                        productJpaEntity.setStatus(updateEntity.getStatus());
                        productJpaEntity.setInventoryQuantity(updateEntity.getInventoryQuantity());
                        ProductJpaEntity updatedProduct = productRepository.save(productJpaEntity);
                        return productMapper.mapToDomainEntity(updatedProduct);
                    })
                    .orElseThrow(() -> new NullPointerException("Product not found"));
        });
    }
}
