package co.edu.ff.orders.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    @Primary
    public UserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    InitializingBean initializingBeanUser(UserDetailsManager manager,
                                          PasswordEncoder passwordEncoder) {
        return () -> {
            boolean userExists = manager.userExists("cbarrientos");
            if (!userExists) {
                UserDetails user = User.builder()
                        .roles("ADMIN")
                        .username("cbarrientos")
                        .password("password")
                        .passwordEncoder(passwordEncoder::encode)
                        .build();
                System.out.println("Run");
                manager.createUser(user);
            }
        };
    }
}
