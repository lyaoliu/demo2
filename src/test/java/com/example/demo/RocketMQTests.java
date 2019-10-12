package com.example.demo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RocketMQTests class
 *
 * @author lyliu
 * @date 2018/10/12 17:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMQTests {
    @Autowired
    private ProducerConfiguration producer;
    @Autowired
    private ConsumerConfiguration consumer;
    @Test
    public void testProducer(){
        try {
          DefaultMQProducer mqProducer=  producer.defaultProducer();
            Message sendMsg = new Message("Topic2","DemoTag","12232333".getBytes());
            //默认3秒超时
            SendResult sendResult =mqProducer.send(sendMsg,10000);
            System.out.println("消息发送响应信息："+sendResult.toString());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testConsume(){
        try {
            consumer.defaultMQPushConsumer("DemoTopic","DemoTag");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

}
