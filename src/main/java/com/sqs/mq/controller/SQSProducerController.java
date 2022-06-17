package com.sqs.mq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqs.mq.model.Employe;
import com.sqs.mq.util.MapperUtil;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SQSProducerController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @PostMapping("/put")
    public void putMessageToQ(@RequestBody Employe employe) throws JsonProcessingException {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(new MapperUtil(new ObjectMapper())
                .convertPOJOToJSON(employe))
                .build());
    }


}
