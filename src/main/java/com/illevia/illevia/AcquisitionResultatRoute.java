package com.illevia.illevia;

import com.illevia.illevia.model.Resultat;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class AcquisitionResultatRoute extends RouteBuilder {

    public static final String REQUESTED_IDENTIFIANT_STATION = "requestedIdentifiantStation";

    public static final String ROUTE_ID = "acquisitionResultatRoute";
    public static final String FROM_ENDPOINT = "direct:" + ROUTE_ID;
    public static JacksonDataFormat recordDataFormat = new JacksonDataFormat(Resultat.class);

    @Override
    public void configure() throws Exception {
        from(FROM_ENDPOINT)
                .routeId(ROUTE_ID)
                .setProperty(REQUESTED_IDENTIFIANT_STATION, body())
                .removeHeader("*")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("https://data.lillemetropole.fr/data/ogcapi/collections/prochains_passages/items?f=json&limit=-1"))
                .to("http:ilevia")
                .unmarshal(recordDataFormat);
    }
}
