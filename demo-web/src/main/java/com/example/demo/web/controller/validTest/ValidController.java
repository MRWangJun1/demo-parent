package com.example.demo.web.controller.validTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangjun
 * @date : 2022/4/1  10:44
 */
@RestController
@RequestMapping("/valid")
public class ValidController {


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@Valid @RequestBody Student student, @ModelAttribute("myUser") User user) {

        return student.toString() + "</br>" + user.toString();
    }


    public static void main(String[] args) {
        List<Course> list = new ArrayList<>();
        list.add(Course.builder().courseName("语文").build());
        list.add(Course.builder().courseName("数学").build());
        Student wangjun = Student.builder().age(22).id(1).name("wangjun").courseList(list).build();
        System.out.println(JSONObject.toJSONString(wangjun));
    }


}
