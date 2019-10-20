package com.java.islamic.DawaPage.DawaPage.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    

    public static String[] userPrevilage = {
        "/password/**","/userpost" ,"/postChoice","/postList","/postNew","/address","/CommentSave","/contact2"};
     public static String[] adminPrevilage = {
        "/user","/userdetail", "/topic","/postAdminPage","/usertopic","/messageInbox"};
     public static String[] noPrevilage = {
       "/","/showPostDetail", "/login",  "/login2", "/webjars/**", "*/js/**", "/css/**"};

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email principal , password credential , user_active  from user where  email=?")
                .authoritiesByUsernameQuery("select  user.email principal ,  role.name role  FROM user, role,user_roles where \n"
                        + "  role.id=user_roles.roles_id and\n"
                        + "  user.user_id=user_roles.users_user_id   and user.email=?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
        
        

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(noPrevilage).permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers(adminPrevilage).hasAnyRole("ADMIN")
                 .antMatchers("/password","/registerform").hasAnyRole("ADMIN","USER")
                .antMatchers(userPrevilage).hasRole("USER")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/");
    }
    
   

}
