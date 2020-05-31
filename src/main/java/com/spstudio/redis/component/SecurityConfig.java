package com.spstudio.redis.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${system.basic-credential.username}")
    String username;

    @Value("${system.basic-credential.password}")
    String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/health-check.html", "/swagger-ui.html")
                    .permitAll()
                    .and()
            .authorizeRequests()
                .anyRequest()
                    .authenticated()
                    .and()
            .httpBasic();
        //@formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(username).password(password).roles("USER");
    }

}
