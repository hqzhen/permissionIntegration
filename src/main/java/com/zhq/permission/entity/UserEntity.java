package com.zhq.permission.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhq.permission.common.base.SuperEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:11
 * @desc 用户entity
 **/
@Data
@TableName("sys_user")
public class UserEntity extends SuperEntity<UserEntity> {

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态")
    private Boolean state;
}
