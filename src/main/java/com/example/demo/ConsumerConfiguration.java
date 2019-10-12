package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConsumerConfiguration class
 *消费者
 * @author lyliu
 * @date 2018/10/12 17:09
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "rocketmq.consumer")
public class ConsumerConfiguration {
    private static final Logger LOGGER= LoggerFactory.getLogger(ConsumerConfiguration.class);
    private String groupName;

    private String namesrvAddr;
    public void defaultMQPushConsumer(String topic,String tag) throws MQClientException {
        //消费者的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        //指定NameServer地址，多个地址以 ; 隔开
        consumer.setNamesrvAddr(namesrvAddr);
        //订阅PushTopic下Tag为push的消息
        consumer.subscribe(topic, tag);
        //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        //如果非第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
            try {
                for (MessageExt messageExt : list) {
                    //输出消息内容
                    LOGGER.info("messageExt: " + messageExt);

                    String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                    //输出消息内容
                    LOGGER.info("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + messageBody);
                }
            } catch (Exception e) {
                LOGGER.error(e.getLocalizedMessage(), e);
                //稍后再试
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            //消费成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        LOGGER.info("rocketmq consumer server开启成功---------------------------------.");
    }
}
