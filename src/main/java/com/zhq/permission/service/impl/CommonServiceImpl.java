package com.zhq.permission.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.zhq.permission.common.utils.FileDownloadUtils;
import com.zhq.permission.service.CommonService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author zhq
 * @create 2022/9/2 20:37
 * @desc
 **/
@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public List<Map<String, Object>> getEnumByEnumName(String enumName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Set<Class<?>> classes = new HashSet<>();
        classes.addAll(ClassUtil.scanPackage("com.zhq"));
        Class<Enum> em = (Class<Enum>) classes.stream()
                .filter(x -> x.isEnum() && enumName.equals(x.getSimpleName())).findFirst()
                .orElse(null);
        Assert.notNull(em, "获取枚举失败,请检查!!!");
        Stream.of(em.getEnumConstants()).forEach(v -> {
            Map<String, Object> map = new HashMap<>();
            List<String> fieldNames = this.getFieldNames(em);
            fieldNames.forEach(x -> {
                map.put(x, ReflectUtil.getFieldValue(v, x));
                map.put("enumName", v.name());
            });
            resultList.add(map);
        });
        return resultList;
    }

    @Override
    public void downloadStaticFile(String resourcesPath, HttpServletResponse response) {
        FileDownloadUtils.downloadStaticFile(resourcesPath, null, response);
    }

    /**
     * 获取 枚举的所有字段
     * 来自 hutool 重写方法入参类型不兼容
     *
     * @param clazz
     * @return List<String>
     */
    private List<String> getFieldNames(Class<Enum> clazz) {
        final List<String> names = new ArrayList<>();
        final Field[] fields = ReflectUtil.getFields(clazz);
        String name;
        for (Field field : fields) {
            name = field.getName();
            if (field.getType().isEnum() || name.contains("$VALUES") || "ordinal".equals(name)) {
                continue;
            }
            if (!names.contains(name)) {
                names.add(name);
            }
        }
        return names;
    }
}
