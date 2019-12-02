package com.movies.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.util.StringUtils;



@Entity
@Table(name = "movies")
public class Movie extends AbstractBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392763345189091136L;
	
	@Column
	@NotBlank(message = "releaseDate could not be empty")
	private String name;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@NotBlank(message = "releaseDate could not be empty")
	private Date releaseDate;
	
	@Column
	@NotBlank(message = "imbdRating could not be empty")
	private Double imbdRating;
	
	@Column
	private Double rottenTomatoesRating;
	
	@Column 
	private String genres;
	
	
	@Column
	private String languages;
	
	
	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	public List<String> getLangaugesAsString(String languages) {
		List<String> list = new ArrayList<String>();
		
		if(this.languages !=null) {
			String[] lngs = this.languages.split(",");
			for(String lng:lngs) {
				String trimed = lng.trim();
				if(!StringUtils.isEmpty(trimed)) {
					list.add(trimed);
				}
			}
		}
		
		return list;
	}

	public List<Genre> getGenreAsList(String genre){
		List<Genre> list = new ArrayList<Genre>();
		if (this.genres != null) {
			String[] gnrs = this.genres.split(",");
			for (String cap : gnrs) {
				String trimed = cap.trim();
				if (!StringUtils.isEmpty(trimed)) {
					Genre gnr = Genre.valueOf(trimed);
					list.add(gnr);
				}
			}
		}
		return list;
	}

	public String getGenre() {
		return genres;
	}

	public void setGenre(String genre) {
		this.genres = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getImbdRating() {
		return imbdRating;
	}

	public void setImbdRating(Double imbdRating) {
		this.imbdRating = imbdRating;
	}

	public Double getRottenTomatoesRating() {
		return rottenTomatoesRating;
	}

	public void setRottenTomatoesRating(Double rottenTomatoesRating) {
		this.rottenTomatoesRating = rottenTomatoesRating;
	}

	
}
