package com.main.srini.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.authorizeRequests()
    	            .anyRequest()
    	            .fullyAuthenticated()
    	            //.permitAll()
    	            .and().httpBasic(); 
    	httpSecurity.csrf().disable();
    }
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication()
		//.passwordEncoder(NoOpPasswordEncoder.getInstance())
		//.withUser("user").password("password").roles("USER");
		.withUser("srini").roles("admin").password(encoder.encode("password")).and()
		.withUser("demo").roles("admin").password(encoder.encode("password"));
	}
	
}
