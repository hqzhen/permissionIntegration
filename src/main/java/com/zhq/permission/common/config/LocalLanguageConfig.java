package com.zhq.permission.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author zhenghongquan
 * @create 2022/8/22 17:55
 * @desc
 **/
public class LocalLanguageConfig {
    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new LanguageLocalResolvers();
    }

    /**
     * 改变语言解析逻辑
     */
    class LanguageLocalResolvers extends AcceptHeaderLocaleResolver {
        /**
         * 语言类型
         */
        List<Locale> locales = Arrays.asList(new Locale("en"), new Locale("zh_CN"));

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String headerLang = request.getHeader("Accept-Language");
            return headerLang == null || headerLang.isEmpty()
                    ? Locale.SIMPLIFIED_CHINESE
                    : Locale.lookup(Locale.LanguageRange.parse(headerLang), locales);
        }
    }
}



