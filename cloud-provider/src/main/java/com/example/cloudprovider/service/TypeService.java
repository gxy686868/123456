package com.example.cloudprovider.service;



import com.jk.entity.Type;

import java.util.HashMap;

public interface TypeService {

    HashMap<String, Object> findtypePage(Type type);

    void updatefile(String ids);

    void del(Integer id);

    void addType(Type type);

    Type findTypeById(Integer id);

    void updateType(Type type);

    void addType2(Type orderVO);
}
