package com.mum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mum.model.User;
import com.mum.security.UrlHandler;
import com.mum.service.SecurityUserServices;

@Configuration
@EnableWebSecurity
public class SecurityAndAuthenticationConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;

	public SecurityAndAuthenticationConfig() {
		userService = new SecurityUserServices();
		successHandler=new UrlHandler();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll()
				.successHandler(successHandler).and().csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new AuthenticationProvider() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String username = (String) authentication.getPrincipal();
				String providedPassword = (String) authentication.getCredentials();
				User user = findAndAuthenticateUser(username, providedPassword);
				if (user == null) {
					throw new BadCredentialsException(
							"Username/Password does not match for " + authentication.getPrincipal());
				}
				
				

				return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			}

			@Override
			public boolean supports(Class<?> authentication) {
				return true;
			}
		});
	}

	public User findAndAuthenticateUser(String username, String providedPassword) {
		User user = (User) userService.loadUserByUsername(username);
		if (user == null) {
			return null;
		}
		if (providedPassword.matches(user.getPassword())) {
			EaKitchenClientApplication.logginInUserId = user.getUserId();
			return user;
		}

		return null;
	}
}
