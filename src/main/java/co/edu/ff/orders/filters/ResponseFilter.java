package co.edu.ff.orders.filters;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
@Order(2)
@Slf4j
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        Stopwatch stopwatch = Stopwatch.createStarted();
        log.info("Logging request {}, {}", request.getMethod(), uri);
        filterChain.doFilter(servletRequest, servletResponse);
        Duration duration = stopwatch.elapsed();
        log.info("Logging response {}: {}", uri, response.getContentType());
        log.info("Request {} took {} millis", uri, duration.toMillis());
    }
}
