package co.edu.ff.orders.products.application.service;

import co.edu.ff.orders.common.UseCase;
import co.edu.ff.orders.products.application.port.out.ProductImagesPort;
import co.edu.ff.orders.products.application.port.in.UploadProductImageUseCase;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UploadProductImageService implements UploadProductImageUseCase {
    private final ProductImagesPort imagesPort;

    @Override
    public Try<String> process(UploadProductImageCommand command) {
        return imagesPort.storeImage(
                command.getId(),
                command.getInputStream(),
                command.getContentLength(),
                command.getContentType(),
                command.getExtension()
        );
    }

    @Override
    public Try<Boolean> hasPermission() {
        return Try.success(true);
    }
}
