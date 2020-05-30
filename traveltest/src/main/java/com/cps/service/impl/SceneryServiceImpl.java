package com.cps.service.impl;

import com.cps.mapper.SceneryMapper;
import com.cps.pojo.Scenery;
import com.cps.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneryServiceImpl implements SceneryService {

    @Autowired
    SceneryMapper sceneryMapper;

    @Override
    public List<Scenery> findAll() {
        return sceneryMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        sceneryMapper.delete(id);
    }

    @Override
    public void add(Scenery scenery) {
        sceneryMapper.add(scenery);
    }

    @Override
    public Integer findCount() {
        return sceneryMapper.findCount();
    }

    @Override
    public List<Scenery> findByLimit(Integer offset, Integer size) {
        return sceneryMapper.findByLimit(offset,size);
    }

    @Override
    public Scenery findById(Integer id) {
        return sceneryMapper.findById(id);
    }

    @Override
    public void updateViews(Integer id) {
        sceneryMapper.updateViews(id);
    }

    @Override
    public List<Scenery> findByQuery(String query) {
        return sceneryMapper.findByQuery(query);
    }

    @Override
    public List<Scenery> findPopular() {
        return sceneryMapper.findPopular();
    }
}
