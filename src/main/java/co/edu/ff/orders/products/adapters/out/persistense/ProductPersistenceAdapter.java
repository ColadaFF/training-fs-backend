package co.edu.ff.orders.products.adapters.out.persistense;

import co.edu.ff.orders.common.PersistenceAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.domain.ProductNotCreated;
import co.edu.ff.orders.products.application.port.out.CreateProductPort;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class ProductPersistenceAdapter implements CreateProductPort {
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
}
