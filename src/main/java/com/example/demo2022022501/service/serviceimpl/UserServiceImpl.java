package com.example.demo2022022501.service.serviceimpl;

import com.example.demo2022022501.dao.UserDao;
import com.example.demo2022022501.dao.UserSpecification;
import com.example.demo2022022501.entity.PageEntity;
import com.example.demo2022022501.entity.UserEntity;
import com.example.demo2022022501.result.ResultData;
import com.example.demo2022022501.service.UserService;
import com.example.demo2022022501.util.PageHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author ASUS
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResultData<Page<UserEntity>> getAllUser(UserEntity userEntity, PageEntity pageEntity) {
        String id = userEntity.getId();
        String name = userEntity.getName();
        Specification<UserEntity> specification = Specification.where(null);
        specification = specification.and(UserSpecification.paramLike("id", id));
        specification = specification.and(UserSpecification.paramLike("name", name));
        Page<UserEntity> all = userDao.findAll(specification, PageHelper.getPage(pageEntity));
        return ResultData.success("success", all);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Object> addUser(UserEntity userEntity) {
        userEntity.setId(UUID.randomUUID().toString());
        while (userDao.existsById(userEntity.getId())) {
            userEntity.setId(UUID.randomUUID().toString());
        }
        try {
            userDao.saveAndFlush(userEntity);
        } catch (Exception e) {
            return ResultData.error();
        }
        return ResultData.successMsg("create user success");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData<Object> deleteUserById(UserEntity userEntity) {
        if (userDao.existsById(userEntity.getId())) {
            try {
                userDao.deleteById(userEntity.getId());
            } catch (Exception e) {
                return ResultData.error();
            }
            return ResultData.successMsg("delete user success");
        } else {
            return ResultData.notFound();
        }
    }

    @Override
    public ResultData<Object> updateUserById(UserEntity userEntity) {
        if (userDao.existsById(userEntity.getId())) {
            try {
                userDao.saveAndFlush(userEntity);
            } catch (Exception e) {
                return ResultData.error();
            }
            return ResultData.successMsg("update user success");
        } else {
            return ResultData.notFound();
        }
    }

}
