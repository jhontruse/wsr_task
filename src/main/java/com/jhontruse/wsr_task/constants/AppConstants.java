package com.jhontruse.wsr_task.constants;

public final class AppConstants {

    public static final String TRACE_ID = "traceId";

    public static final String HEADER_TRACE_ID = "X-Trace-Id";

    public static final String HTTP_METHOD = "method";

    public static final String ENDPOINT = "endpoint";

    public static final String IP = "ip";

    public static final String STATUS = "status";

    private AppConstants() {
        throw new UnsupportedOperationException("Clase de constantes - no debe instanciarse");
    }

}
