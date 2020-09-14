package com.example.cloudprovider.controller;

import com.example.cloudprovider.service.TypeService;
import com.jk.entity.Type;
import com.jk.service.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("type")
public class TypeController implements TypeServices {
    @Autowired
    private TypeService typeService;

    //分页+条查+查findgoodPage
    public HashMap<String, Object> findtypePage( Type type){
        return typeService.findtypePage(type);
    }


    //批量删除
    public void updatefile(String ids){
        System.out.println(ids);
        typeService.updatefile(ids);
    }

    //删除
    public void del(Integer id){
        System.out.println(id);
        typeService.del(id);
    }

    //新增addGoods
    public void addType(Type type){
        System.out.println(type);
        typeService.addType(type);
    }

    //回显findTypeById
    public Type findTypeById( Integer id){
        System.out.println(id+"服务回显");
        return typeService.findTypeById(id);
    }

    //修改updateType
    public void updateType(Type type){
        typeService.updateType(type);
    }
}
