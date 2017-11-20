package com.quinn.crm.utils;


import java.util.List;

public interface BaseDao<T>{
    //查询所有
    List<T> findAll();
    //高级查询(根据传入参数)
    List<T> find(T t);
    //保存数据
    void save(T t);
    //更改数据
    void update(T t);
    //删除数据
    void delete(T t);

}
