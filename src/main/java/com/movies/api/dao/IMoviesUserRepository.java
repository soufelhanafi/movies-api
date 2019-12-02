/**
 * 
 */
package com.movies.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.movies.api.model.MoviesUser;

/**
 * @author sabir
 *
 */
public interface IMoviesUserRepository extends CrudRepository<MoviesUser, Long> {

	public MoviesUser findByEmail(String email);

}
