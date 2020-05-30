package com.cps.controller;

import com.cps.pojo.Scenery;
import com.cps.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 搜索景点
 */
@Controller
public class SearchController {

    @Autowired
    SceneryService sceneryService;

    @PostMapping("/search")
    public String search(@RequestParam("query") String query,
                         Model model) {

        // 根据前端传来的关键词query 去数据库查询相关的景点（正则查询）
        if (!"".equals(query.trim())) {
            List<Scenery> sceneries = sceneryService.findByQuery(query);
            Integer counts = sceneries.size();
            model.addAttribute("sceneries",sceneries);
            model.addAttribute("counts",counts);
        }else {
            // 如果搜索的关键为空 则返回全部景点
            List<Scenery> sceneries = sceneryService.findAll();
            Integer counts = sceneries.size();
            model.addAttribute("sceneries",sceneries);
            model.addAttribute("counts",counts);
        }

        return "search";
    }

}
