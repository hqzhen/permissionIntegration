package com.zhq.permission.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhenghongquan
 * @create 2022/8/22 13:40
 * @desc 雪花id工具
 **/
@Component
public class SnowflakeIdUtils {

    private static Snowflake snowflake;

    protected SnowflakeIdUtils(@Value("${id.workerId:${random.int[0,31]}}")Long workerId,
                               @Value("${id.datacenterId:${random.int[0,31]}}")Long datacenterId){

        SnowflakeIdUtils.snowflake= IdUtil.createSnowflake(workerId, datacenterId);
    }

    public static Long getId() {
        return snowflake.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(snowflake.nextId());
    }
}
