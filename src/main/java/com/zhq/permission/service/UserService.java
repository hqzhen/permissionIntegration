package com.zhq.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhq.permission.common.pojo.vo.UserVO;
import com.zhq.permission.entity.UserEntity;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:16
 * @desc 用户信息服务
 **/
public interface UserService extends IService<UserEntity> {
    /**
     * 新增用户
     * @param vo 前端入参
     * @return Boolean
     */
    Boolean addUser(UserVO vo);
}
