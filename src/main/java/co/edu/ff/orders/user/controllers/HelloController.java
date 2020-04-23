package co.edu.ff.orders.user.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {
    @GetMapping(path = "/{id}")
    public String greeting(Authentication authentication, @PathVariable("id") String id) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return "Hello world GET: " + principal.getAuthorities() + ": " + id;
    }

    @PostMapping(path = "/{id}")
    public String greetingPost(@PathVariable("id") String id) {
        return "Hello world POST: " + id;
    }

    @PutMapping(path = "/{id}")
    public String greetingPut(@PathVariable("id") String id) {
        return "Hello world PUT: " + id;
    }

    @DeleteMapping(path = "/{id}")
    public String greetingDelete(@PathVariable("id") String id) {
        return "Hello world DELETE: " + id;
    }
}
