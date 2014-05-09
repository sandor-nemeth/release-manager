/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.releasemanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author sandornemeth
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/", "/app/bower_components/**").permitAll()
                    .antMatchers("/app/**").authenticated()
                    .antMatchers("/api/**").authenticated();
            http.httpBasic().realmName("My realm");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");
        }
        
        @Bean public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }
        
        @Bean public RoleHierarchy roleHierarchy() {
            RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
            roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_EDITOR > ROLE_USER");
            return roleHierarchy;
        }
        
        @Bean public RoleVoter roleVoter() {
            return new RoleHierarchyVoter(roleHierarchy());
        }

    
}
