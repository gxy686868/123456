package com.jk.arrbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//当前类为一个配置文件类
public class RabbitConfig {

    @Bean//把创建的列放入spring bean 容器中方便使用
    public Queue creatQueue(){
        return new Queue("delorder");
    }

    @Bean//把创建的列放入spring bean 容器中方便使用
    public Queue AddQueue(){
        return new Queue("addorder");
    }

    @Bean//把创建的列放入spring bean 容器中方便使用
    public Queue AddQueue2(){
        return new Queue("addorder2");
    }
}
