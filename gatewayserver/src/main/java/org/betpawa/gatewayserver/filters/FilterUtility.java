package org.betpawa.gatewayserver.filters;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "betPawa-correlation-id";


    public String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID);
//            assert requestHeaderList != null;
            return requestHeaderList.stream().findFirst().get();
        } else {
            return null;
        }
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, correlationId);
    }

    private ServerWebExchange setRequestHeader(ServerWebExchange exchange, String value) {
        return exchange.mutate()
                .request(exchange.getRequest()
                                        .mutate()
                                        .header(FilterUtility.CORRELATION_ID, value).build())
                .build();
    }
}
