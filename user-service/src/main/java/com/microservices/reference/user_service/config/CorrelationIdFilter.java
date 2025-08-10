package com.microservices.reference.user_service.config;

import com.microservices.reference.common.utils.MdcUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String correlationId = request.getHeader("X-Correlation-ID");
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = MdcUtils.generateCorrelationId();
        } else {
            MdcUtils.putCorrelationId(correlationId);
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            MdcUtils.clear();
        }
    }
}