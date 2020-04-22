package co.edu.ff.orders.configuration;


import co.edu.ff.orders.products.application.domain.*;
import co.edu.ff.orders.serialization.NumberValueAdapter;
import co.edu.ff.orders.serialization.StringValueAdapter;
import co.edu.ff.orders.serialization.TryAdapter;
import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.Username;
import co.edu.ff.orders.user.exceptions.UserException;
import com.google.gson.*;
import io.vavr.control.Try;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson() {
        Function<String, Password> creator = new Function<String, Password>() {
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };

        return new GsonBuilder()
                .registerTypeAdapter(Username.class, new StringValueAdapter<>(Username::of))
                .registerTypeAdapter(Password.class, new StringValueAdapter<>(creator))
                .registerTypeAdapter(BasePrice.class, new NumberValueAdapter<>(BasePrice::fromNumber))
                .registerTypeAdapter(ProductId.class, new NumberValueAdapter<>(ProductId::fromNumber))
                .registerTypeAdapter(TaxRate.class, new NumberValueAdapter<>(TaxRate::fromNumber))
                .registerTypeAdapter(Quantity.class, new NumberValueAdapter<>(Quantity::fromNumber))
                .registerTypeAdapter(ProductName.class, new StringValueAdapter<>(ProductName::of))
                .registerTypeAdapter(ProductDescription.class, new StringValueAdapter<>(ProductDescription::of))
                .registerTypeAdapter(UserException.class, (JsonSerializer<UserException>) (src, typeOfSrc, context) -> {
                    JsonObject jsonObject = new JsonObject();
                    String message = src.getMessage();
                    JsonPrimitive errorValue = new JsonPrimitive(message);
                    jsonObject.add("error", errorValue);
                    return jsonObject;
                })
                .registerTypeAdapter(Try.class, new TryAdapter<>())
                .create();
    }
}
