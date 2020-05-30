package com.cps.mapper;

import com.cps.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    // 新增评论
    void addComment(Comment comment);

    // 查询某个景点的评论
    List<Comment> findById(Integer id);

    //查找所有的评论
    List<Comment> findAll();

    //查找指定id的评论
    void delete(Integer id);
}
