package com.gqb.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guoqb
 * @date : 2019/12/12 22:46
 * @descript 注册拦截器到springboot
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    InterceptConfig interceptConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptConfig)
                .addPathPatterns("/**")
                .excludePathPatterns("/111","222");
    }
}
