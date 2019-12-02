/**
 * 
 */
package com.movies.api.security;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movies.api.dao.IMoviesUserRepository;
import com.movies.api.model.MoviesUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IMoviesUserRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MoviesUser account = accountRepository.findByEmail(email);
		if (account == null) {
			throw new UsernameNotFoundException(email);
		}
		return new User(account.getEmail(), account.getPassword(), emptyList());
	}
}