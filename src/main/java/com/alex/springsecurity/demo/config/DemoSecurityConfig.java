package com.alex.springsecurity.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource securityDataSource;
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.jdbcAuthentication().dataSource(securityDataSource);
            
	}

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers( "/homepage", "/", "/user/signup", "user/signin?error", "/search", "/user/processSignup", "/resources/css/style.css", "/user/successignup", "products/AddToCartLink", "/user", "/user/signin", "/denied").permitAll()
                .antMatchers("/panel").hasRole("ADMIN")
                .antMatchers("/Panel/panel/list").hasRole("ADMIN")
                .antMatchers("/about").hasAnyRole("USER", "ADMIN")
                .antMatchers("/contact").hasAnyRole("USER", "ADMIN")
                .antMatchers("/products").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()        
                    .loginPage("/user/signin")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout().logoutSuccessUrl("/homepage").logoutUrl("/homepage").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/http/denied");
                
    }
}




