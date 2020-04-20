package co.edu.ff.orders;

import co.edu.ff.orders.user.domain.UserAuthRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class OrdersApiApplication {

	public Boolean isEmptyList(Collection<?> collection) {
		Predicate<Collection<?>> collectionIsNotEmpty = col -> !col.isEmpty();
		return Optional.ofNullable(collection)
				.filter(collectionIsNotEmpty)
				.isPresent();
	}



	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}

}
