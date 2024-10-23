package com.illevia.illevia;

import com.illevia.illevia.model.Resultat;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class IntegrationGetRecordsByIdStation extends RouteBuilder {

    public static final String ROUTE_ID = "routeIntegrationGetRecordsByIdStation";
    public static final String FROM_ENDPOINT = "direct:" + ROUTE_ID;
    @Override
    public void configure() throws Exception {
        from(FROM_ENDPOINT).routeId(ROUTE_ID)
                .to(AcquisitionResultatRoute.FROM_ENDPOINT)
                .to(IntegrationResultatRoute.FROM_ENDPOINT);
    }
}
