package com.zhq.permission.common.utils;

import cn.hutool.core.io.IoUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author zhq
 * @create 2022/9/2 20:49
 * @desc 文件下载工具
 **/
public class FileDownloadUtils {

    /**
     * 执行下载
     * l
     *
     * @param wb
     * @param response
     * @param fileName
     * @throws Exception
     */
    @SneakyThrows
    public static void download(Workbook wb, HttpServletResponse response, String fileName) {
        OutputStream out = download(response, fileName);
        wb.write(out);
        out.flush();
        out.close();
    }


    /**
     * 执行下载
     *
     * @param bytes
     * @param response
     * @param fileName
     * @throws Exception
     */
    @SneakyThrows
    public static void download(byte[] bytes, HttpServletResponse response, String fileName) {
        OutputStream out = download(response, fileName);
        out.write(bytes);
        out.flush();
        out.close();
    }


    @SneakyThrows
    public static OutputStream download(HttpServletResponse response, String fileName) {
        response.setContentType("application/octet-stream");
        String encode = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);
        OutputStream out = response.getOutputStream();
        return out;
    }


    /**
     * 读取系统资源目录下 文件下载
     *
     * @param resourcesPath
     * @param fileName      为空, 为空默认读取 系统文件名称
     * @param response
     * @throws IOException
     */
    @SneakyThrows
    public static void downloadStaticFile(String resourcesPath, String fileName, HttpServletResponse response) {
        ClassPathResource classPathResource = new ClassPathResource(resourcesPath);
        String file = StringUtils.isBlank(fileName) ? classPathResource.getFilename() : fileName;
        byte[] bytes = IoUtil.readBytes(classPathResource.getInputStream());
        download(bytes, response, file);
    }

}
