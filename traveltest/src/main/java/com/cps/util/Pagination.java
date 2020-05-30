package com.cps.util;

import lombok.Data;

/**
 * 分页工具
 */
@Data
public class Pagination {

    private boolean showPrevious;
    private boolean showNext;
    private Integer page;
    private Integer totalPage;
    private Integer counts;

    public void setPagination(Integer counts,Integer page,Integer size){
        // 判断该分多少页
        int totalPage;
        if (counts % size == 0){
            totalPage = counts / size;
        }else {
            totalPage = counts / size + 1;
        }

        // 总页数
        this.totalPage = totalPage;
        // 总条数
        this.counts = counts;

        // 容错处理
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        this.page = page;

        // 第一页时 不显示上一页
        showPrevious = page != 1;

        // 最后一页时 不显示下一页
        showNext = page != totalPage;

    }

}
