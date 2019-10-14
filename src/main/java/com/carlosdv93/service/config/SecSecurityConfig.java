package com.carlosdv93.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImps userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/api/restaurante").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.GET, "/login").permitAll().anyRequest().authenticated()
				.and().formLogin();
		/*
		 * .antMatchers(HttpMethod.GET, "/cadastrarEvento").hasRole("ADMIN")
		 * .antMatchers(HttpMethod.POST,
		 * "/cadastrarEvento").hasRole("ADMIN").anyRequest().authenticated().and()
		 * .formLogin().permitAll().and().logout().logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout"));
		 */
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
		// auth.userDetailsService(userDetailsService).passwordEncoder(new
		// BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/**", "/style/**");
	}
}
