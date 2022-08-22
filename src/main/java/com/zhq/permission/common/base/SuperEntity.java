package com.zhq.permission.common.base;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhenghongquan
 * @create 2022/8/22 13:53
 * @desc mybatis-plus 自定义父类entity
 **/
@Data
@ApiModel
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
public class SuperEntity <T extends Model<T>> extends Model<T> implements Serializable {

    private static final long serialVersionUID = 7560570481504032191L;

    @ApiModelProperty(value = "主键雪花ID")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(hidden = true)
    @TableField(value = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @ApiModelProperty(hidden = true)
    @TableField(value = "create_user_id")
    private Long createUserId;

    @ApiModelProperty(hidden = true)
    @TableField(value = "modify_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    @ApiModelProperty(hidden = true)
    @TableField(value = "modify_user_id")
    private Long modifyUserId;

    @ApiModelProperty(hidden = true)
    @TableField(value = "delete_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteDate;

    @ApiModelProperty(hidden = true)
    @TableField(value = "delete_user_id")
    private Long deleteUserId;

    @ApiModelProperty(hidden = true)
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(hidden = true)
    @TableField("version")
    @Version
    private Long version;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
