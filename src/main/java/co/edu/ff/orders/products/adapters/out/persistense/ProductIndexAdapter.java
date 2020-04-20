package co.edu.ff.orders.products.adapters.out.persistense;

import co.edu.ff.orders.common.PersistenceAdapter;
import co.edu.ff.orders.products.application.domain.Product;
import co.edu.ff.orders.products.application.port.out.IndexProductPort;
import com.google.gson.Gson;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductIndexAdapter implements IndexProductPort {
    private final RestHighLevelClient elasticClient;
    private final ProductMapper productMapper;
    private final Gson gson;

    @Override
    public Try<Product> indexProduct(Product product) {
        return Try.of(() -> {
            String id = product.getId().getValue().toString();
            ProductIndexEntity productIndexEntity = productMapper.mapToIndexEntity(product);
            String jsonDocument = gson.toJson(productIndexEntity);
            IndexRequest indexRequest = new IndexRequest("products")
                    .id(id)
                    .source(jsonDocument, XContentType.JSON);

            elasticClient.index(indexRequest, RequestOptions.DEFAULT);
            return product;
        });
    }
}
