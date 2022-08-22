package com.zhq.permission;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author zhenghongquan
 */
@Slf4j
@SpringBootApplication
public class PermissionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PermissionApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        log.info("启动完成->>>访问文档:http://{}:{}{}/doc.html", NetUtil.getLocalhost().getHostAddress(),
                environment.getProperty("server.port"), environment.getProperty("server.servlet.context-path"));
    }

}
