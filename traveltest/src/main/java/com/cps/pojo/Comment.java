package com.cps.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 评论
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;
    private Integer sid;
    private String name;
    private String content;
    private String email;
    private Date createTime;

}
