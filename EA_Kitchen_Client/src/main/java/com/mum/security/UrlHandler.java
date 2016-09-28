package com.mum.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mum.model.User;
import com.mum.model.UserOld;
import com.mum.model.UserRole;

@Service
public class UrlHandler implements AuthenticationSuccessHandler {

	// protected Log logger = LogFactory.getLog(this.getClass())
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		handle(request, response, authentication);
		//clearAuthenticationAttributes(request);
	}

	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			// logger.debug("Response has already been committed. Unable to
			// redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Builds the target URL according to the logic defined in the main class
	 * Javadoc.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		/*
		 * Collection<? extends GrantedAuthority> authorities =
		 * authentication.getAuthorities(); for (GrantedAuthority
		 * grantedAuthority : authorities) {
		 */
		User currentUser = (User) authentication.getPrincipal();
		String currentRole = currentUser.getUserRole().toString();
		if (currentRole.equals(UserRole.ROLE_COMMITTEE.toString())) {
			return "/home";
		} else if (currentRole.equals(UserRole.ROLE_CUSTOMER.toString())) {
			return "/customer";
		} else if (currentRole.equals(UserRole.ROLE_FARMER.toString())) {
			return "/scheduleFarmerProduceList";
		} else {
			throw new IllegalStateException();
		}
		/*
		 * } return "/login";
		 */
	}

	/*protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}*/

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
