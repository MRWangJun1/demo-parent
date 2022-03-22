package com.example.demo.web.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2022/3/7  18:08
 */
public class Send {

    private final static String QUEUE_NAME = "simple_queue";
//
//    public static void main(String[] argv) throws Exception {
//        // 1、获取到连接
//        Connection connection = ConnectionUtil.getConnection();
//        // 2、从连接中创建通道，使用通道才能完成消息相关的操作
//        Channel channel = connection.createChannel();
//        // 3、声明（创建）队列
//        //参数：String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
//        /**
//         * 参数明细
//         * 1、queue 队列名称
//         * 2、durable 是否持久化，如果持久化，mq重启后队列还在
//         * 3、exclusive 是否独占连接，队列只允许在该连接中访问，如果connection连接关闭队列则自动删除,如果将此参数设置true可用于临时队列的创建
//         * 4、autoDelete 自动删除，队列不再使用时是否自动删除此队列，如果将此参数和exclusive参数设置为true就可以实现临时队列（队列不用了就自动删除）
//         * 5、arguments 参数，可以设置一个队列的扩展参数，比如：可设置存活时间
//         */
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        // 4、消息内容
////        StringBuilder message = "Hello World!";
//        // 向指定的队列中发送消息
//        //参数：String exchange, String routingKey, BasicProperties props, byte[] body
//        /**
//         * 参数明细：
//         * 1、exchange，交换机，如果不指定将使用mq的默认交换机（设置为""）
//         * 2、routingKey，路由key，交换机根据路由key来将消息转发到指定的队列，如果使用默认交换机，routingKey设置为队列的名称
//         * 3、props，消息的属性
//         * 4、body，消息内容
//         */
//
//
//        for (int i = 0; i < 100; i++) {
//            channel.basicPublish("", QUEUE_NAME, null, ("Hello World!"+i).getBytes());
//            System.out.println(" [x] Sent '" + ("Hello World!"+i) + "'");
//            Thread.sleep(i * 2);
//        }
//
//
//        //关闭通道和连接(资源关闭最好用try-catch-finally语句处理)
//        channel.close();
//        connection.close();
//    }


    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();

        //sentSimple(connection);

//        sentFanout(connection);

        sentDirect(connection);



    }


    /**
     * 普通模式 即直接发送到指定的队列  默认交换机
     */
    public static void sentSimple(Connection connection) throws Exception {
        Channel channel = connection.createChannel();
        String queueName = "sentSimple";
        //申明队列
        channel.queueDeclare(queueName, false, false, false, null);
        //发布到默认交换机
        channel.basicPublish("", queueName, null, "啥也不说".getBytes());
        System.out.println("发布成功");
        channel.close();
        connection.close();
    }



    /**
     * 广播模式   指定交换机 并发送消息
     */
    public static void sentFanout(Connection connection) throws Exception {
        Channel channel = connection.createChannel();
        String customExchange="customExchange";
        //申明交换机 为广播模式
        channel.exchangeDeclare(customExchange,BuiltinExchangeType.FANOUT,true);
        //发送广播
        for (int i = 0; i < 1000; i++) {
            channel.basicPublish(customExchange,"",null,("广播来了"+i).getBytes());
            System.out.println("广播发布成功"+i);
            Thread.sleep(100*i);
        }
        channel.close();
        connection.close();
    }

    /**
     * 路由模式   指定交换机
     */

    public static void sentDirect(Connection connection) throws Exception {
        Channel channel = connection.createChannel();
        String provideDirect = "provideDirect";
        //申明交换机 为广播模式
        channel.exchangeDeclare(provideDirect, BuiltinExchangeType.DIRECT, true);
        //发送广播
        String msg;
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                msg = "sms来了" + i;
                channel.basicPublish(provideDirect, "sms", null, msg.getBytes());
            } else {
                msg = "mail来了" + i;
                channel.basicPublish(provideDirect, "mail", null, msg.getBytes());
            }
            System.out.println(msg);
            Thread.sleep(i);
        }
        channel.close();
        connection.close();
    }









}
