package com.cps.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 景点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenery {

    private Integer id;
    private String title;
    private String content;
    private String photo;
    private String description;
    private Date creatTime;
    private Integer views;

}
