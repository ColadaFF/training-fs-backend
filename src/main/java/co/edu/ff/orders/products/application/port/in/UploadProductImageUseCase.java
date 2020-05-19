package co.edu.ff.orders.products.application.port.in;

import co.edu.ff.orders.products.application.domain.ProductId;
import io.vavr.control.Try;
import lombok.Value;

import java.io.InputStream;

public interface UploadProductImageUseCase {

    Try<String> process(UploadProductImageCommand command);

    Try<Boolean> hasPermission();


    @Value(staticConstructor = "of")
    class UploadProductImageCommand {
        ProductId id;
        InputStream inputStream;
        Long contentLength;
        String contentType;
        String extension;
    }

}
