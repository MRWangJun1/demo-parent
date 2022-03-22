package com.example.demo.dao.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : wangjun
 * @date : 2022/3/11  11:47
 */
@Document(collation = "demo_collection")
@Data
public class DemoEntity {
    @Id
    private Long id;
    @Indexed
    private String title;

    private String description;

    private String by;

    private String url;
}
