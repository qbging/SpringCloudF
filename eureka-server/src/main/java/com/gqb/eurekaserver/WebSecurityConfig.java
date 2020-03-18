package com.gqb.eurekaserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    /**
    * @Description: 高版本的丢弃了
     * security:
     *   basic:
     *     enabled: true 配置，应该使用以下方式开启
    * @Param: [http]
    * @Return: void
    */
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure HttpSecurity as needed (e.g. enable http basic).
        http.csrf().disable();
        super.configure(http);
 
    }
}