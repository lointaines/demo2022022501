package com.example.demo2022022501.service;

import com.example.demo2022022501.entity.PageEntity;
import com.example.demo2022022501.entity.UserEntity;
import com.example.demo2022022501.result.ResultData;
import org.springframework.data.domain.Page;

/**
 * @author ASUS
 */
public interface UserService {
    /**
     * return all user by pageEntity
     * @param userEntity 包含查询条件的用户实体类对象
     * @param pageEntity 包含分页信息的分页实体类对象
     * @return 一个 `ResultData` 对象，包括分页信息和查询结果集合
     */
    ResultData<Page<UserEntity>> getAllUser(UserEntity userEntity, PageEntity pageEntity);
    /**
     * 增加user
     * @param userEntity 包含查询条件的用户实体类对象
     * @return 一个 `ResultData` 对象，包括执行结果和返回信息
     */
    ResultData<Object> addUser(UserEntity userEntity);
    /**
     * 通过id删除user
     * @param userEntity 包含查询条件的用户实体类对象
     * @return 一个 `ResultData` 对象，包括分页信息和查询结果集合
     */
    ResultData<Object> deleteUserById(UserEntity userEntity);
    /**
     * 通过id更新
     * @param userEntity 包含查询条件的用户实体类对象
     * @return 一个 `ResultData` 对象，包括分页信息和查询结果集合
     */
    ResultData<Object> updateUserById(UserEntity userEntity);
}
