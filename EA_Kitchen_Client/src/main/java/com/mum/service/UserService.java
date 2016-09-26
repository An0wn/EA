package com.mum.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mum.model.User;

@Service
public class UserService implements UserDetailsService {
	private static final String ServiceURL = "http://localhost:8081/EA_Kitchen_Server/rest";
	private static final String userbyUserNameURL = ServiceURL + "/getUserByUserName/{username}";
	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
		ResponseEntity<User> response = restTemplate.exchange(userbyUserNameURL, HttpMethod.GET, null, typeRef);
		User puser = response.getBody();
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
				puser.getUsername(), puser.getPassword(),
				AuthorityUtils.createAuthorityList(puser.getUserRole().toString()));
		return user;
	}

}
