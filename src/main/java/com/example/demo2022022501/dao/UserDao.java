package com.example.demo2022022501.dao;

import com.example.demo2022022501.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ASUS
 */
public interface UserDao extends JpaRepository<UserEntity, String> , JpaSpecificationExecutor<UserEntity> {

}
