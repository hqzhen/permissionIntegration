package com.zhq.permission.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zhq.permission.common.base.SuperServiceImpl;
import com.zhq.permission.common.pojo.vo.UserVO;
import com.zhq.permission.entity.UserEntity;
import com.zhq.permission.mapper.UserMapper;
import com.zhq.permission.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:21
 * @desc 用户服务实现
 **/
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public Boolean addUser(UserVO vo) {
        UserEntity userEntity = new UserEntity();
        BeanUtil.copyProperties(vo,userEntity);
        userEntity.setState(true);
        return this.save(userEntity);
    }
}
