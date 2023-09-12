package io.dmullandev.kafka.producer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dmullandev.kafka.constants.KafkaAppConstants;
import io.dmullandev.kafka.model.BusinessObject;

@RestController
@RequestMapping("api/v1/businessobjects")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, BusinessObject> kafkaTemplateBusinessObject;

    private static final Logger LOG = LogManager.getLogger(KafkaProducerController.class);

    public KafkaProducerController(KafkaTemplate<String, BusinessObject> kafkaTemplateBusinessObject) {
        this.kafkaTemplateBusinessObject = kafkaTemplateBusinessObject;
    }

    @PostMapping
    public void publish(@RequestBody BusinessObject businessObject) {
        LOG.info("Received business object {}", businessObject);
        kafkaTemplateBusinessObject.send(KafkaAppConstants.APP_TOPIC_BUSINESSOBJECT, businessObject);
    }

    /*
     * public static void main(String[] args) { BusinessObject object = new
     * BusinessObject(); BasicBusinessObjectInformation bboi = new
     * BasicBusinessObjectInformation(); bboi.setObjectType("KAFKA_TYPE");
     * bboi.setObjectDescription("Object for relaying kafka object information");
     * object.setBusinessObjectId(999);
     * object.setBasicBusinessObjectInformation(bboi);
     * 
     * ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter(); try
     * { String json = ow.writeValueAsString(object); System.out.println(json); }
     * catch (JsonProcessingException e) {
     * 
     * }
     * 
     * }
     */
}
