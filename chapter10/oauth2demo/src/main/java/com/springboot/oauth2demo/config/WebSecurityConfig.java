package com.springboot.oauth2demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ：HappyCheng
 * @date ：2019/10/29
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$JXUgdfnGD/ytq/u5TLMvb.yTfaoNYO5udSvRYcEz8a6wDTHZQvDxq")
                .roles("admin")
                .and()
                .withUser("sang")
                .password("$2a$10$JXUgdfnGD/ytq/u5TLMvb.yTfaoNYO5udSvRYcEz8a6wDTHZQvDxq")
                .roles("user");
    }

    @Override //SpringSecurity 中的httpSecurity 配置高于资源服务器中的httpSecurity配置
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**").authorizeRequests() //配置"/oauth/**"模式的url，这一类请求直接放行
                .antMatchers("/oauth/**").permitAll()
                .and().csrf().disable();
    }
}
