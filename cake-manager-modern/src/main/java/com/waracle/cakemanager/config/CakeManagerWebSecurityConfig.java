package com.waracle.cakemanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security config file to be run with dev profile so that security can be applied to various endpoints
 * @author Abilash
 */
@EnableWebSecurity
@Configuration
@Profile("dev")
public class CakeManagerWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
				.antMatchers("/oauth2-redirect.html", "/swagger-ui.html", "/v3/api-docs", "/swagger-ui/index.html",
						"/swagger-ui/**", "/api/loggedin/confirm/**", "/api/loggedin/confirm/",
						"/public/oauth2-redirect.html", "/context-path/v3/api-docs", "/context-path/v3/api-docs/**",
						"/swagger-ui-custom.html")
				.permitAll().antMatchers(HttpMethod.GET, "/**").hasAuthority("SCOPE_read")
				.antMatchers(HttpMethod.POST, "/cakes").hasAuthority("SCOPE_write").anyRequest().authenticated().and()
				.oauth2ResourceServer().jwt();
	}

}