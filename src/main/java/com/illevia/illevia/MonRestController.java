package com.illevia.illevia;

import com.illevia.illevia.model.Record;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("illeviarest/prochainPassages/station/{idStation}")
public class MonRestController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<Record> controller(@PathVariable String idStation) {
        return producerTemplate.requestBody(IntegrationGetRecordsByIdStation.FROM_ENDPOINT, idStation, List.class);
    }


}
