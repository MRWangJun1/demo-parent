package com.example.demo.web.controller.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author : wangjun
 * @date : 2022/3/25  16:13
 */
@Data
@Document(collection = "demo_collection")
public class MongoTest implements Serializable {
    @Id
    private Integer id;
    private Integer age;
    private String name;
}
