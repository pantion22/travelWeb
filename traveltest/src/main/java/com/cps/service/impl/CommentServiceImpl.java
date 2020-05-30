package com.cps.service.impl;

import com.cps.mapper.CommentMapper;
import com.cps.pojo.Comment;
import com.cps.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public List<Comment> findById(Integer id) {
        return commentMapper.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        commentMapper.delete(id);
    }
}
