package com.example.demo.web.redis;


import lombok.Data;

import java.io.Serializable;

/**
 * @author : wangjun
 * @date : 2022/3/10  16:17
 */
@Data
public class Student implements Serializable {
    private String openId;
    private String daysId;
    private String title;
    private int itemNumber;
}
