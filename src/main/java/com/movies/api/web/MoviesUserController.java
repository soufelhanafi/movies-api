package com.movies.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.dao.IMoviesUserRepository;
import com.movies.api.model.MoviesUser;
import com.movies.api.service.IMoviesUserService;



@RestController
@RequestMapping("/api")
public class MoviesUserController {

	@Autowired
	private IMoviesUserService taxiClicUserService;

	@Autowired
	private IMoviesUserRepository taxiClicRepository;

	@PostMapping("/public/user/create")
	public MoviesUser createNewUser(@RequestBody MoviesUser account) {

		MoviesUser newAccount = this.taxiClicUserService.createNewMoviesUser(account);

		return newAccount;

	}

	@GetMapping("/private/user/get")
	public MoviesUser getCurrentUser() {

		String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MoviesUser user = taxiClicRepository.findByEmail(userEmail);

		return user;

	}

}
