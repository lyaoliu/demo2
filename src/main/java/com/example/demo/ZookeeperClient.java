package com.example.demo;

import lombok.Data;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ZookeeperClient class
 *
 * @author lyliu
 * @date 2019/04/10 11:29
 */
@Component
@Data
@ConfigurationProperties(
        prefix = "spring.zookeeper"
)
public class ZookeeperClient {
    private String connectString;
    private int  sessionTimeout;
    private Watcher watcher;
    public ZooKeeper init() throws IOException {
        ZooKeeper zooKeeper=new ZooKeeper(connectString,sessionTimeout,watcher);
        return  zooKeeper;
    }

}
