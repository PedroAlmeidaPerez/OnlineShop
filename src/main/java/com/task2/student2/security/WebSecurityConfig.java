package com.task2.student2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/productspublic","/createuser","/resultuser").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

      /* auth.inMemoryAuthentication()
                .withUser("pedro").password("pedro").roles("USER")
                .and()
                .withUser("lukasz").password("lukasz").roles("USER")
                .and()
                .withUser("mateusz").password("mateusz").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    */}
}

/*

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/productspublic","/createuser","/resultuser").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    /*DataSource dataSource;
    // create 4 users, admin and 3 users
    @Override
    protected void configure (AuthenticationManagerBuilder auth)
        throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource);
    */
  /*  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      /*  auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name,user_password, enabled from customers where user_name=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
*/
    /*    auth.inMemoryAuthentication()
                .withUser("pedro").password("pedro").roles("USER")
                .and()
                .withUser("lukasz").password("lukasz").roles("USER")
                .and()
                .withUser("mateusz").password("mateusz").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }
}*/