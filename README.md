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
```
