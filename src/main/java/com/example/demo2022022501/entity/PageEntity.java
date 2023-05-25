package com.example.demo2022022501.entity;

import lombok.Data;

/**
 * @author ASUS
 */
@Data
public class PageEntity {
    private Integer pageSize;
    private Integer currentPage;
    private String orderField;
    private String orderDirection;

    public PageEntity(){
        pageSize = 10;
        currentPage = 1;
        orderField = "id";
        orderDirection = "asc";
    }
}
