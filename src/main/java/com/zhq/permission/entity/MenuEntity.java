package com.zhq.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.permission.common.base.mybatisplus.SuperEntity;
import lombok.Data;

/**
 * @author zhenghongquan
 * @create 2022/8/23 10:30
 * @desc 菜单
 **/
@Data
@TableName("sys_menu")
public class MenuEntity extends SuperEntity<MenuEntity> {
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Boolean visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    private Boolean status;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 菜单图标
     */
    private String icon;
}
