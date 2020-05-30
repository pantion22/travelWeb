package com.cps.controller;

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
 * 景点详情页
 */
@Controller
public class SceneryController {

    @Autowired
    SceneryService sceneryService;

    @Autowired
    CommentService commentService;

    @GetMapping("/scenery")
    public String scenery(@RequestParam("id") Integer id,
                          Model model){
        // 根据前端传来的id去数据库查询对应的景点
        Scenery scenery = sceneryService.findById(id);
        model.addAttribute("scenery",scenery);

        // 每一次访问详情页，对应的景点的热度views就要+1
        sceneryService.updateViews(id);

        // 查询该景点的评论内容 带到前端页面去
        List<Comment> comments = commentService.findById(id);
        model.addAttribute("comments",comments);

        return "scenery";
    }

    // 接收前端传来的评论信息
    @PostMapping("/scenery")
    public String comment(@RequestParam("id") Integer id,
                          @RequestParam("content") String content,
                          @RequestParam("name") String name,
                          @RequestParam("email") String email){

        // 保存留言
        if (!"".equals(content.trim())||!"".equals(name.trim())||!"".equals(email.trim())) {
            Comment comment = new Comment();
            comment.setSid(id);
            comment.setName(name);
            comment.setContent(content);
            comment.setEmail(email);
            comment.setCreateTime(new Date());
            commentService.addComment(comment);

            // 重定向到发布评论的这个页面 避免了重复提交
            return "redirect:/scenery?id=" + id;
        }else {
            return "error/500";
        }
    }

}
