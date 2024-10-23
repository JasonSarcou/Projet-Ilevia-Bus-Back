package com.illevia.illevia;

import com.google.gson.Gson;
import com.illevia.illevia.model.Record;
import com.illevia.illevia.model.Resultat;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.util.json.JsonObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.illevia.illevia.AcquisitionResultatRoute.REQUESTED_IDENTIFIANT_STATION;


@Component
public class IntegrationResultatRoute extends RouteBuilder {

    public static final String ROUTE_ID = "integrationResultatRoute";
    public static final String FROM_ENDPOINT = "direct:" + ROUTE_ID;

    @Override
    public void configure() throws Exception {
        from(FROM_ENDPOINT).routeId(ROUTE_ID)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        final Resultat resultat = exchange.getIn().getBody(Resultat.class);
                        if (resultat.getRecords() != null) {
                            final List<Record> filteredRecords = resultat.getRecordsByIdentifiantStation(exchange.getProperty(REQUESTED_IDENTIFIANT_STATION, String.class));
                            final Resultat finalResult = new Resultat(filteredRecords);
                            exchange.getIn().setBody(filteredRecords);
                            //JsonObject jo = new JsonObject();
                            //jo.put("records", filteredRecords);
                            //String json = new Gson().toJson(filteredRecords);
                        }
                    }
                });
                //.marshal(AcquisitionResultatRoute.recordDataFormat);

    }
}
