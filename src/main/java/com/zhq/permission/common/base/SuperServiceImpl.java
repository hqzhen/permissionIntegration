package com.zhq.permission.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhq.permission.common.utils.SnowflakeIdUtils;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:04
 * @desc   mybatis-plus 自定义父类service
 **/
public class SuperServiceImpl <M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    /**
     * 获取一个新的long类型雪花id
     *
     * @return Long
     */
    public Long getNextId() {
        return SnowflakeIdUtils.getId();
    }

    /**
     * 获取一个新的String类型雪花id
     * @return String
     */
    public String getNextIdStr() {
        return SnowflakeIdUtils.getIdStr();
    }
}
