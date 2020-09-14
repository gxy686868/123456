package com.example.cloudprovider.service.impl;

import com.example.cloudprovider.mapper.TypeMapper;
import com.example.cloudprovider.service.TypeService;
import com.jk.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;


    //查+条查+分页
    @Override
    public HashMap<String, Object> findtypePage(Type type) {
        //查询总条数
        int count=typeMapper.findresPageCount(type);
        int start = (type.getPage()-1)*type.getRows();
        Integer rows = type.getRows();
        List<Type> list = typeMapper.findresPage(start,rows,type);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows",list);
        return map;
    }

    //批量删除
    @Override
    public void updatefile(String ids) {
        typeMapper.updatefile(ids);
    }

    //单删
    @Override
    public void del(Integer id) {
        typeMapper.del(id);
    }

    //新增
    @Override
    public void addType(Type type) {
        for (int i = 0; i <100 ; i++) {//主线程
            new Thread(new Runnable() {//new一个线程类，实现runnble接口
                @Override
                public void run() {//子线程
                    for (int j = 0; j <500 ; j++) {
                            typeMapper.addType(type);
                    }
                }
            }).start();//start()让线程进入就绪状态
            System.out.println(type);
        }

    }

    //回显
    @Override
    public Type findTypeById(Integer id) {
        return typeMapper.findTypeById(id);
    }
    //修改
    @Override
    public void updateType(Type type) {
        typeMapper.updateType(type);
    }

    @Override
    @Async//开启异步处理
    public void addType2(Type orderVO) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
