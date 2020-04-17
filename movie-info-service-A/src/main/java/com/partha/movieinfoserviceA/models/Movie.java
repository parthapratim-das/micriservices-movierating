package com.partha.movieinfoserviceA.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {
	
	@Id
	private int id;
	private String movieId;
	private String movieName;
	private String movieDesc;
	public Movie(String movieId, String movieName, String movieDesc) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
	}
	
	
	public Movie() {
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	
}
