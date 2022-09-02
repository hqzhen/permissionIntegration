package com.zhq.permission.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Objects;

/**
 * @author zhq
 * @create 2022/9/2 21:12
 * @desc
 **/
@Getter
public enum StateEnum {
    /**
     * 禁用
     */
    DISABLED(0, "禁用"),
    ACTIVATION(1, "激活"),
    ;
    @EnumValue
    private final Integer value;

    private final String name;

    StateEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static StateEnum getEnum(Integer value) {
        return EnumSet.allOf(StateEnum.class)
                .stream().filter(o -> Objects.equals(o.getValue(), value)).findFirst().orElse(null);
    }

}
