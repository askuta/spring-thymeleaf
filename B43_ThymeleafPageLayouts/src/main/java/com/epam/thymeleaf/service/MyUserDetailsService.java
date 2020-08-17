package com.epam.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.thymeleaf.auth.UserPrincipal;
import com.epam.thymeleaf.entity.AuthGroup;
import com.epam.thymeleaf.entity.User;
import com.epam.thymeleaf.repository.AuthGroupRepository;
import com.epam.thymeleaf.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthGroupRepository authGroupRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("Cannot find username: " + username);
		}

		List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);

		return new UserPrincipal(user, authGroups);
	}
}
