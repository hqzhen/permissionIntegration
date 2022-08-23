package com.zhq.permission.common.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import com.zhq.permission.common.utils.ResultAssertUtils;
import com.zhq.permission.entity.UserEntity;
import com.zhq.permission.mapper.MenuMapper;
import com.zhq.permission.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhenghongquan
 * @create 2022/8/23 10:53
 * @desc
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserEntity::getUserName, username);
        UserEntity user = userMapper.selectOne(queryWrapper);
        ResultAssertUtils.isNotNull(user, PermissionErrorCode.USER_DOES_NOT_EXIST.ex());
        ResultAssertUtils.isTrue(user.getState(), PermissionErrorCode.USER_IS_LOCKED_OR_INACTIVE.ex());
        //TODO 获取权限
        List<String> perms = menuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetails返回
        return new LoginUser(user, perms);
    }
}
