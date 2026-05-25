package com.jhontruse.wsr_task.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import com.jhontruse.wsr_task.constants.AppConstants;

@Slf4j
@Component
public class TraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        try {
            // Reutiliza traceId si viene del cliente
            String traceId = request.getHeader(AppConstants.HEADER_TRACE_ID);
            if (traceId == null || traceId.isBlank()) {
                traceId = generateTraceId();
            }

            // Guardar en MDC
            MDC.put(AppConstants.TRACE_ID, traceId);
            MDC.put(AppConstants.HTTP_METHOD, request.getMethod());
            MDC.put(AppConstants.ENDPOINT, request.getRequestURI());
            MDC.put(AppConstants.IP, getClientIp(request));


            // Retornar traceId al cliente
            response.setHeader(AppConstants.HEADER_TRACE_ID, traceId);
            log.info("Inicio request {} {}", request.getMethod(), request.getRequestURI());
            filterChain.doFilter(request, response);

            // ===== STATUS HTTP =====
            MDC.put(AppConstants.STATUS, String.valueOf(response.getStatus()));
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            MDC.put("duration", duration + "ms");
            log.info("Fin request - duración={}ms", duration);
            // MUY IMPORTANTE
            MDC.clear();
        }

    }

    private String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
    }

    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isBlank()) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
