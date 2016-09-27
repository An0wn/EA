/*package edu.mum.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.mum.DAO.UserDAO;
import edu.mum.model.User;
import edu.mum.model.UserRole;

public class UserSecurity implements UserDetailsService {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	UserDAO userService;
	
	 * @Override public UserDetails getUserByUserName(String username) { User
	 * user userService.loadUserByUsername(username); }
	 * 
	 * @Override public boolean loginUser(String username, String password) {
	 * UserDetails userDetails = userService.loadUserByUsername(username);
	 * UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	 * new UsernamePasswordAuthenticationToken( userDetails, password,
	 * userDetails.getAuthorities());
	 * authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	 * if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	 * SecurityContextHolder.getContext().setAuthentication(
	 * usernamePasswordAuthenticationToken); return true; } return false; }
	 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUserName(username);
		if (user.equals(null)) {
			throw new UsernameNotFoundException("No user with this username");
		} else {
			List<String> userRoles = new ArrayList<String>();
			userRoles.add(UserRole.ROLE_COMMITTEE.toString());
			userRoles.add(UserRole.ROLE_CUSTOMER.toString());
			userRoles.add(UserRole.ROLE_FARMER.toString());
			return new CustomerUser(user, userRoles);
		}
	}
}
*/