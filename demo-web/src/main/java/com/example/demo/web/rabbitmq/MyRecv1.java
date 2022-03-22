package com.example.demo.web.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2022/3/10  13:40
 */
public class MyRecv1 {


//    public static void main(String[] args) throws Exception {
//        Connection connection = ConnectionUtil.getConnection();
//        Channel channel = connection.createChannel();
//        String queueName = "fanout1";
//        channel.queueDeclare(queueName, true, false, false, null);
//
//        channel.queueBind(queueName,"customExchange","");
//
//
//
//
//        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                String msg = new String(body);
//                System.out.println(" [x] received : " + msg + "!");
////                channel.basicAck(envelope.getDeliveryTag(), false);
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        channel.basicConsume(queueName, true, defaultConsumer);
//
//    }



    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName = "direct";
        channel.queueDeclare(queueName, false, false, false, null);

        channel.queueBind(queueName,"provideDirect","sms");

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println(" [x] received : " + msg + "!");
//                channel.basicAck(envelope.getDeliveryTag(), false);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        channel.basicConsume(queueName, true, defaultConsumer);

    }







}
