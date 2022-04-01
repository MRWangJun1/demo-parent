package com.example.demo.web.controller.validTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : wangjun
 * @date : 2022/4/1  14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -4156361183130219179L;
    private Integer userId;
    private String userName;
}
