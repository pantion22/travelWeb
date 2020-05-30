package com.cps.service;

import com.cps.pojo.Comment;

import java.util.List;

public interface CommentService {

    // 新增评论
    void addComment(Comment comment);

    // 查询某个景点的评论
    List<Comment> findById(Integer id);

    //查找所有的评论
    List<Comment> findAll();

    void delete(Integer id);
}
