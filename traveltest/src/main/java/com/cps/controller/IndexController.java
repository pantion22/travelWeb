package com.cps.controller;

import com.cps.pojo.Scenery;
import com.cps.service.SceneryService;
import com.cps.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 主页
 */
@Controller
public class IndexController {

    @Autowired
    SceneryService sceneryService;

                        @GetMapping({"/","index","index.html"})
                        public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        // 去数据库把景点的信息查出来 传到主页
        //List<Scenery> sceneries = sceneryService.findAll();

        // 总景点数
        Integer counts = sceneryService.findCount();

        // 调用分页工具类
        Pagination pagination = new Pagination();
        pagination.setPagination(counts,page,size);
        model.addAttribute("pagination",pagination);
        // 重新给page赋值 防止不合法的page页访问
        page = pagination.getPage();

        // 分页查询
        Integer offset = size * (page - 1);
        List<Scenery> sceneries = sceneryService.findByLimit(offset,size);
        model.addAttribute("sceneries",sceneries);

        //选出前三的热门景点
        List<Scenery> popularitys = sceneryService.findPopular();
        model.addAttribute("popularitys",popularitys);

        return "index";
    }

}
