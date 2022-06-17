package com.sqs.mq.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class MapperUtil {

    private ObjectMapper objectMapper;

    public MapperUtil(ObjectMapper objectMapper){
        this.objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }
    /*
        Convert POJO to JSON
     */
    public  String convertPOJOToJSON(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /*
        Convert JSON to POJO
     */
    public Object convertJSONToPOJO(String json) throws JsonProcessingException {
        return objectMapper.readValue(json,Object.class);
    }


}
