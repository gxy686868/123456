package com.example.cloudprovider.rabbit;

import com.alibaba.fastjson.JSON;
import com.example.cloudprovider.service.TypeService;
import com.jk.entity.Type;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component//把当前监听类配置到spring环境中
public class OrderRabbitListener {
    @Autowired
    private TypeService typeService;
    //删除
    @RabbitListener(queues = "delorder")
    public void updatefile(String ids){
        //typeService.updatefile(ids);
        System.out.println(ids);
    }

    //新增
    @RabbitListener(queues = "addorder")
    public void addType(String type){
        Type orderVO = JSON.parseObject(type, Type.class);
        System.out.println(orderVO);
        typeService.addType(orderVO);
    }

    @Autowired
    private Executor springThreadPool;//线程池
    //新增2
    @RabbitListener(queues = "addorder2")
    public void addType2(String type){
        springThreadPool.execute(()->{
            Type orderVO = JSON.parseObject(type, Type.class);
            System.out.println(orderVO);
            typeService.addType2(orderVO);
        });
    }
}
