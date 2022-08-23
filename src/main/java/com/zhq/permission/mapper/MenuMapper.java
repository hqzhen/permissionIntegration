package com.zhq.permission.mapper;

import com.zhq.permission.common.base.mybatisplus.SuperMapper;
import com.zhq.permission.entity.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhenghongquan
 * @create 2022/8/23 10:33
 * @desc
 **/
public interface MenuMapper extends SuperMapper<MenuEntity> {

    /**
     * 查询权限标识
     * @param userId 用户id
     * @return List<String>
     */
    List<String> selectPermsByUserId(@Param("userId") Long userId);
}
