package com.example.demo2022022501.dao;

import com.example.demo2022022501.entity.UserEntity;
import com.example.demo2022022501.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author ASUS
 */
public class UserSpecification {

    public static Specification<UserEntity> paramLike(String propertyName,String value) {
        if(StringUtils.isEmpty(value)){
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(propertyName), "%" + value + "%");
    }
}
