/**
 * 
 */
package com.movies.api.security;

import static com.movies.api.security.SecurityConstants.EXPIRATION_TIME_IN_MS;
import static com.movies.api.security.SecurityConstants.SECRET;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.api.model.MoviesUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Ce filtre est pour gérer la partie authentification et la génération du token
 * 
 * @author sabir
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private static final Logger log = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		String email = null;
		try {
			MoviesUser creds = new ObjectMapper().readValue(req.getInputStream(), MoviesUser.class);

			email = creds.getEmail();
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(email, creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			log.error("User failed to authenticate, email: '{}'", email, e);
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		// On génère le token
		Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MS);
		String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).getUsername()).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

		// On le met dans la réponse
		JSONObject object = new JSONObject();
		object.put("expireDate", expireDate);
		object.put("x-auth-token", "Bearer " + token);

		String strJsonRes = object.toString();
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(strJsonRes);
		res.getWriter().flush();
	}
}
