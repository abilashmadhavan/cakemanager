package com.waracle.cakemanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security config file to be run with test profile so that security can be ignored while running junits
 * @author Abilash
 */
@Configuration
@Profile("test")
public class CakeManagerTestWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/**");
	}

}