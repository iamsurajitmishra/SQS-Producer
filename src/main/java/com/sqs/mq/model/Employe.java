package com.sqs.mq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    private String name;
    private long salary;
    private Address address;
}
