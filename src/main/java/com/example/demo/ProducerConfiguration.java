package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * MQProducerConfiguration class
 *
 * @author lyliu
 * @date 2018/10/12 16:48
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
@ToString
@Getter
@Setter
public class ProducerConfiguration {
    private static final Logger LOGGER= LoggerFactory.getLogger(ProducerConfiguration.class);
    private String namesrvAddr;
    private String groupName;
    public DefaultMQProducer defaultProducer() throws MQClientException {
        LOGGER.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(10);
        producer.start();
        LOGGER.info("rocketmq producer server开启成功---------------------------------.");
        return producer;
    }
}
