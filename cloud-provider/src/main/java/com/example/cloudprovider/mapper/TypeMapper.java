package com.example.cloudprovider.mapper;

import com.jk.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TypeMapper {
    int findresPageCount(@Param("type") Type type);

    List<Type> findresPage(@Param("start")int start, @Param("rows")Integer rows, @Param("type")Type type);

    void updatefile(@Param("ids") String ids);

    void del(Integer id);

    void addType(Type type);

    Type findTypeById(Integer id);

    void updateType(Type type);
}
