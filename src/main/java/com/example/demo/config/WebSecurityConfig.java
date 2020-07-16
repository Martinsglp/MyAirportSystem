package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Anonymous;


@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
        protected UserDetailsService userDetailsService() {
                InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
                
                manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("123").roles("ADMIN").build());
                manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build());
               
                return manager;
                
        }
	
	 
	//Encryption for passwords
	@Bean
        public PasswordEncoder passwordEncoder()
        {
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
	
	
	
	@Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
      }
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/guest/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/h2-console/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .and()
        .logout().permitAll();

          
        http.csrf().disable();
        http.headers().frameOptions().disable();
                    
    }
	
	
	

}
