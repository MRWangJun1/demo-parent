package com.example.demo.web.controller.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author : wangjun
 * @date : 2022/3/24  14:38
 */
public class CustomizePartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> map) {

    }

    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        // 自定义分区规则(这里假设全部发到0号分区)
        return 0;
    }

    @Override
    public void close() {

    }
}
