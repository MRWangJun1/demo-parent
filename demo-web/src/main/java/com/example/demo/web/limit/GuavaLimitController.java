package com.example.demo.web.limit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2022/4/14  11:54
 */
@RestController
@RequestMapping("/guavaLimit")
public class GuavaLimitController {


    @RequestMapping("/visitTimes")
    @GuavaLimit(key = "visitTimes", qps = 10)
    public String visitTimes() throws Exception{

//       TimeUnit.SECONDS.sleep(1);
        return "访问成功";
    }


}
