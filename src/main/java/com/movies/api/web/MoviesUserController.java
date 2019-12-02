package com.movies.api.web;

import org.springframework.beans.BeanUtils;
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

	@PostMapping("/public/accounts")
	public AccountDTO createNewTaxiClicUser(@RequestBody MoviesUser account) {

		MoviesUser newAccount = this.taxiClicUserService.createNewMoviesUser(account);

		return this.accountToDTO(newAccount);

	}

	@GetMapping("/private/accounts")
	public AccountDTO getCurrentTaxiClicUser() {

		String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MoviesUser findByEmail = taxiClicRepository.findByEmail(userEmail);

		return this.accountToDTO(findByEmail);

	}

	/**
	 * Account to DTO.
	 * 
	 * Account est un objet sensible qu'il ne faut jamais retourner au front !
	 *
	 * @param account the account
	 * @return the account DTO
	 */
	protected AccountDTO accountToDTO(MoviesUser account) {

		AccountDTO dto = new AccountDTO();

		BeanUtils.copyProperties(account, dto);

		return dto;
	}
}
