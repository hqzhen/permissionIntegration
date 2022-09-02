package com.zhq.permission.service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zhq
 * @create 2022/9/2 20:36
 * @desc
 **/
public interface CommonService {
    /**
     * 通过枚举类名或者枚举值
     * @param enumName 枚举名称
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getEnumByEnumName(String enumName);

    /**
     * 下载静态文件
     * @param resourcesPath 文件路径
     * @param response 文件
     */
    void downloadStaticFile(String resourcesPath, HttpServletResponse response);
}
