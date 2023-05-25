package com.example.demo2022022501.util;

import com.example.demo2022022501.entity.PageEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author ASUS
 */
public class PageHelper {
    public static Pageable getPage(PageEntity pageEntity){
        return PageRequest.of(pageEntity.getCurrentPage()-1,pageEntity.getPageSize(),getDirection(pageEntity.getOrderDirection()), pageEntity.getOrderField());
    }

    private static Sort.Direction getDirection(String direction) {
        return "desc".equals(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

}
