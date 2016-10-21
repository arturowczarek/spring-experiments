package com.owczarek.protectedservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class HttpSecurityConfig {
    @Configuration
    public static class UrlSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                        .antMatchers("/employee*")
                        .hasAuthority("EMPLOYEE")
                        .and()
                    .authorizeRequests()
                        .antMatchers("/customer*")
                        .hasAuthority("CUSTOMER")
                        .and()
                    .authorizeRequests()
                        .antMatchers("/authenticated*")
                        .authenticated()
                        .and()
                    .logout();
        }
    }
}
