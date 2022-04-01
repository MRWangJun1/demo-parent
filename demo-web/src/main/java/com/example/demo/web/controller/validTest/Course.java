package com.example.demo.web.controller.validTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author : wangjun
 * @date : 2022/4/1  10:28
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {

    private static final long serialVersionUID = -1970614351383076167L;

    private String courseName;

    @NotNull(message = "课程Id不能为空")
    private Integer courseId;
}
