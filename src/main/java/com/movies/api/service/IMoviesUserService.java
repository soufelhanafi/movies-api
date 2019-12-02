/**
 * 
 */
package com.movies.api.service;

import com.movies.api.model.MoviesUser;

/**
 * @author sabir
 *
 */
public interface IMoviesUserService {
	
	public MoviesUser createNewMoviesUser(MoviesUser account);
	
	public MoviesUser getMoviesUserById(Long accountId);
	
	public MoviesUser updateBasicMoviesUserInfos(Long accountId, MoviesUser accountDetails);
	
	public MoviesUser loadMoviesUserByEmail(String email);
}
