package com.jk.service;

import com.jk.entity.Type;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("type")
public interface TypeServices {
    //查+分页+条查
    @PostMapping("findtypePage")
    HashMap<String, Object> findtypePage(@RequestBody Type type);

    //批量删除
    @GetMapping("updatefile/{ids}")
    void updatefile(@PathVariable("ids") String ids);

    //单删
    @GetMapping("del/{id}")
    void del(@PathVariable("id")Integer id);

    //新增
    @PostMapping("addType")
    void addType(@RequestBody Type type);

    //回显
    @GetMapping("findTypeById/{id}")
    Type findTypeById(@PathVariable("id") Integer id);

    //修改
    @PostMapping("updateType")
    void updateType(@RequestBody Type type);

}
