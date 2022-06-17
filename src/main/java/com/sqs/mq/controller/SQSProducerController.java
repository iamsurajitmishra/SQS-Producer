package com.sqs.mq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sqs.mq.model.Employe;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1")
public class SQSProducerController {

    private ObjectMapper objectMapper;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @PostConstruct
    public void init(){
        objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @PostMapping("/put")
    public void putMessageToQ(@RequestBody Employe employe) throws JsonProcessingException {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(objectMapper.writeValueAsString(employe))
                .build());
    }


}
