package co.edu.ff.orders.user.services;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Service
public class ApplicationUserAuthServices implements UserDetailsService {

    private final Map<String, User> users = ImmutableMap.of(
            "cbarrientos", new User("cbarrientos", "{bcryp}$2y$04$MmTgVxvuKggLnb0hCrKDoeqFVE0QrsNP9J9w.brQHFAU6aNC4fhie",
                    Arrays.asList(() -> "ADMIN")),
            "ecatano", new User("ecatano", "password",
                    Arrays.asList(() -> "MANAGER")
            )
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }
}
