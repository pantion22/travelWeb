package com.cps.controller.admin;

import com.cps.mapper.SceneryMapper;
import com.cps.pojo.Comment;
import com.cps.pojo.Scenery;
import com.cps.service.CommentService;
import com.cps.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 后台管理
 */
@Controller
public class AdminController {

    @Autowired
    SceneryService sceneryService;
    @Autowired
    CommentService commentService;

    @GetMapping("/admin")
    public String admin(Model model){
        // 去数据库查询景点信息 显示到后台控制页
        List<Scenery> sceneries = sceneryService.findAll();
        model.addAttribute("sceneries",sceneries);
        return "admin/index";
    }

    // 删除某个景点
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        // 接收前端传来的景点id 进行删除
        sceneryService.delete(id);
        return "redirect:/admin";
    }

    // 去添加景点的页面
    @GetMapping("/admin/add")
    public String toAdd(){
        return "admin/add-place";
    }

    // 添加景点
    @PostMapping("/admin/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("content") String content,
                      @RequestParam("photo") String photo,
                      @RequestParam("description") String description){
        // 获取前端传来的值
        Scenery scenery = new Scenery();
        scenery.setTitle(title);
        scenery.setContent(content);
        scenery.setPhoto(photo);
        scenery.setCreatTime(new Date());
        scenery.setDescription(description);

        // 存到数据库
        sceneryService.add(scenery);

        return "redirect:/index";
    }


    // 去管理评论的页面
    @GetMapping("/admin/delComment")
    public String toDelComment(Model model){
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments",comments);
        return "admin/delComment";
    }

    // 删除某个评论
    @GetMapping("/delCom")
    public String delCom(@RequestParam("id") Integer id) {
        // 接收前端传来的评论id 进行删除
        commentService.delete(id);
        return "redirect:/admin/delComment";
    }



}
