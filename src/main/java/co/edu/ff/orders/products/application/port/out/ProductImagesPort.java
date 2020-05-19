package co.edu.ff.orders.products.application.port.out;

import co.edu.ff.orders.products.application.domain.ProductId;
import io.vavr.control.Try;

import java.io.File;
import java.io.InputStream;

public interface ProductImagesPort {
    Try<String> storeImage(ProductId id, InputStream inputStream, Long size, String contentType, String extension);
}
