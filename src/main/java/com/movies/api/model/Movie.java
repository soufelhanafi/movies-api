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
	private String title;
	
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
	
	@Column
	private String extrnalId;
	
	@Column
	private String overview;
	
	@Column
	private String homepageUrl;
	
	@Column
	private boolean adult;
	
	@Column
	private String imbdId;
	
	@Column
	private long revenue;
	
	@Column
	private long popularity;
	
	@Column 
	private double voteAverage;
	
	@Column
	private double voteCount;
	
	@Column
	private int runtime;
	
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getExtrnalId() {
		return extrnalId;
	}

	public void setExtrnalId(String extrnalId) {
		this.extrnalId = extrnalId;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getHomepageUrl() {
		return homepageUrl;
	}

	public void setHomepageUrl(String homepageUrl) {
		this.homepageUrl = homepageUrl;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getImbdId() {
		return imbdId;
	}

	public void setImbdId(String imbdId) {
		this.imbdId = imbdId;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public long getPopularity() {
		return popularity;
	}

	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public double getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(double voteCount) {
		this.voteCount = voteCount;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	
}
