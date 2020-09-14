package com.jk.service;

import com.jk.controller.TypeController;
import com.jk.entity.Type;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Component //把项目将级类配置到spring
@RequestMapping("prodvide/error") //为了防止冲突
public class ProductErrorTip implements TypeService {
    @Override
    public HashMap<String, Object> findtypePage(Type type) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg","当前网络不稳定 请重试");
        return resultMap;
    }

    @Override
    public void updatefile(String ids) {

    }

    @Override
    public void del(Integer id) {

    }

    @Override
    public void addType(Type type) {

    }

    @Override
    public Type findTypeById(Integer id) {
        return null;
    }

    @Override
    public void updateType(Type type) {

    }
}
