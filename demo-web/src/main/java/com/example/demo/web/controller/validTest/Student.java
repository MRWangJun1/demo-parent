package com.example.demo.web.controller.validTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author : wangjun
 * @date : 2022/4/1  10:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 3062439130272197038L;
    @NotNull(message = "学生Id不能为空")
    private Integer id;


    @NotBlank(message = "学生名不能为空")
    private String name;


    @NotEmpty(message = "学生所选的课程不能为空")
//    @Valid
    private List<Course> courseList;

    @NotNull(message = "学生年龄不能为空")
    private Integer age;
}
