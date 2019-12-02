/**
 * 
 */
package com.movies.api.service;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movies.api.dao.IMoviesUserRepository;
import com.movies.api.exception.EmailAlreadyExistsException;
import com.movies.api.model.MoviesUser;

@Service
@Transactional
public class MoviesUserServiceImpl implements IMoviesUserService {

	@Autowired
	private IMoviesUserRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder cryptEncoderService;

	private static final Logger log = LoggerFactory.getLogger(MoviesUserServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.datafuture.testplus.api.service.IAccountService#createNewAccount(fr.
	 * datafuture.testplus.api.model.Account)
	 */
	@Override
	public MoviesUser createNewMoviesUser(MoviesUser account) {

		// TODO : il faut implémenter les règles indiquées dans la Javadoc
		MoviesUser accountFound = this.accountRepository.findByEmail(account.getEmail());
		if (accountFound != null) {
			throw new EmailAlreadyExistsException(account.getEmail());
		}

		account.setPassword(this.cryptEncoderService.encode(account.getPassword()));

		return this.accountRepository.save(account);
	}

	@Override
	public MoviesUser loadMoviesUserByEmail(String email) {
		return this.accountRepository.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.datafuture.testplus.api.service.IAccountService#getAccountById(java.
	 * lang.Long)
	 */
	@Override
	public MoviesUser getMoviesUserById(Long accountId) {

		Optional<MoviesUser> opAccount = this.accountRepository.findById(accountId);

		return opAccount.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.datafuture.testplus.api.service.IAccountService#updateAccountInfos(
	 * java.lang.Long, fr.datafuture.testplus.api.model.Account)
	 */
	@Override
	public MoviesUser updateBasicMoviesUserInfos(Long accountId, MoviesUser accountDetails) {

		log.info("updateBasicAccountInfos for account {}", accountId);

		// Account existingAccount = this.getAccountById(accountId);

		// TODO : prendre les infos *non null* dans accountDetails et les mettre
		// dans existingAccount

		accountDetails.setId(accountId);
		accountDetails.setModifDate(new Date());

		return this.accountRepository.save(accountDetails);
	}


}
