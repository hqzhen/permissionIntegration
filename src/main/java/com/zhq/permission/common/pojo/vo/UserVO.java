package com.zhq.permission.common.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author zhenghongquan
 * @create 2022/8/22 14:30
 * @desc
 **/
@Data
public class UserVO {

    @NotBlank
    @ApiModelProperty(value = "邮箱")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "姓名")
    private String userName;

    @NotBlank
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态",hidden = true)
    private Boolean state;
}
