# permissionIntegration
SpringSecurity 整合 JWT+Oauth2 认证实战
###相关表
```sql
CREATE TABLE `sys_user` (
                            `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'ID',
                            `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
                            `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
                            `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
                            `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态,0表示禁用，1表示启用',
                            `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
                            `modify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `modify_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
                            `delete_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
                            `delete_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '删除人',
                            `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除,不允许为空，默认值为 0',
                            `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '乐观锁',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
CREATE TABLE `sys_menu` (
                            `id` bigint(20) NOT NULL COMMENT '主键',
                            `menu_name` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单名',
                            `path` varchar(100) NOT NULL DEFAULT '' COMMENT '路由地址',
                            `component` varchar(100) NOT NULL DEFAULT '' COMMENT '组件路径',
                            `visible` tinyint(2) NOT NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
                            `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
                            `perms` varchar(100) NOT NULL DEFAULT '' COMMENT '权限标识',
                            `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单图标',
                            `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
                            `modify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `modify_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
                            `delete_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
                            `delete_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '删除人',
                            `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除,不允许为空，默认值为 0',
                            `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '乐观锁',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `sys_role` (
                            `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'ID',
                            `role_code` varchar(50) NOT NULL DEFAULT '' COMMENT '角色编码',
                            `role_name` varchar(100) NOT NULL DEFAULT '' COMMENT '角色名称',
                            `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
                            `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态,0表示禁用，1表示启用',
                            `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
                            `modify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `modify_time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
                            `modify_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
                            `delete_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
                            `delete_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '删除人',
                            `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除,不允许为空，默认值为 0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
CREATE TABLE `sys_role_menu` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                 `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
                                 `menu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '菜单id',
                                 `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `create_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
                                 `modify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `modify_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
                                 `delete_date` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
                                 `delete_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '删除人',
                                 `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除,不允许为空，默认值为 0',
                                 `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '乐观锁',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';

```
