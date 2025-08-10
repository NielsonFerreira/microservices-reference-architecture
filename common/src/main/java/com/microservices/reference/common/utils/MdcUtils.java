package com.microservices.reference.common.utils;

import org.slf4j.MDC;

import java.util.UUID;

public class MdcUtils {

    public static final String CORRELATION_ID = "correlationId";

    public static void putCorrelationId(String correlationId) {
        MDC.put(CORRELATION_ID, correlationId);
    }

    public static void clear() {
        MDC.clear();
    }

    public static String generateCorrelationId() {
        String correlationId = UUID.randomUUID().toString();
        putCorrelationId(correlationId);
        return correlationId;
    }

    public static String getCorrelationId() {
        return MDC.get(CORRELATION_ID);
    }
}
