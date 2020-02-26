package com.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @description:
 * @author: fandp
 * @create: 2020-02-25 09:37
 **/
public class SimpleDemoMain {
    // 使用nacos client 远程获取nacos服务上的配置信息
    public static void main(String[] args) throws NacosException {
        //地址
        String serverAddr = "127.0.0.1:8848";
        //命名空间
        String nameSpace = "a5cd7e73-3b4d-449f-8cfe-82281bc85463";
        //Data Id
        String dataId = "nacos-simple-demo.yaml";
        //Group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace", nameSpace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        //获取配置：String dataId,String group,long timeoutMs
        String content = configService.getConfig(dataId,group,5000);
        System.out.println(content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }
            //当配置有变化的时候，获取通知
            @Override
            public void receiveConfigInfo(String s) {
              System.out.println(s);
            }
        });
        //为了演示监听功能 不能让程序停下来
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
