package co.edu.ff.orders.products.adapters.out.storage;

import co.edu.ff.orders.products.application.domain.ProductId;
import co.edu.ff.orders.products.application.port.out.ProductImagesPort;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.UUID;

@Repository
public class S3ProductImages implements ProductImagesPort {
    private final AmazonS3 s3Client;
    private final String BUCKET = "ias-product-api-images";

    @Autowired
    public S3ProductImages(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }


    @Override
    public Try<String> storeImage(ProductId id, InputStream inputStream, Long size, String contentType, String extension) {
        return Try.of(() -> {
            String uuid = UUID.randomUUID().toString();
            String key = String.format("%s/%s.%s", id.getValue(), uuid, extension);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(size);
            metadata.setContentType(contentType);
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET, key, inputStream, metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult putObjectResult = s3Client.putObject(putObjectRequest);
            return putObjectResult.getETag();
        });
    }
}
