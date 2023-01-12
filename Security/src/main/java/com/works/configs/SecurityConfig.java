package com.works.configs;

import com.works.services.AdminDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final PasswordEncoder passwordEncoder;
    final AdminDetailService detailService;

    // SLQ -> login
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailService).passwordEncoder(passwordEncoder);
    }

    // Login type -> Role -> Mapping
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/product/**").hasRole("product")
        .antMatchers("/note/**").hasRole("note")
        .and().formLogin().disable().csrf().disable();
        http.headers().frameOptions().disable();
    }

}

/*
serkan@mail.com -> product
ahmet@mail.com -> note
zehra@mail.com -> product, note
 */
