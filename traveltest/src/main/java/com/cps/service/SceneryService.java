package com.cps.service;

import com.cps.pojo.Scenery;

import java.util.List;

public interface SceneryService {

    // 查询所有景点的信息 按最新发布时间排序
    List<Scenery> findAll();

    // 根据id删除某个景点的信息
    void delete(Integer id);

    // 新增景点
    void add(Scenery scenery);

    // 查询景点的总数
    Integer findCount();

    // 分页查询景点信息
    List<Scenery> findByLimit(Integer offset,Integer size);

    // 根据id查询景点
    Scenery findById(Integer id);

    // 更新景点的热度 +1
    void updateViews(Integer id);

    // 根据关键词搜索景点
    List<Scenery> findByQuery(String query);

    // 显示前三的热门景点
    List<Scenery> findPopular();

}
