package co.edu.ff.orders.products.adapters.out.persistense;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductJpaEntity, Long> {

}
