package com.example.demo.web;

import com.example.demo.web.bootstrap.DemoWebApplication;
import com.example.demo.web.rabbitmq.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : wangjun
 * @date : 2022/3/8  15:54
 */
@SpringBootTest(classes = DemoWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class Send {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsgByTopics() {

        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        for (int i = 0; i < 5; i++) {
            String message = "恭喜您，注册成功！userid=" + i;
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, "topic.sms.email", message);
            System.out.println(" [x] Sent '" + message + "'");
        }

    }
}
