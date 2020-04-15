package com.partha.movieinfoserviceA.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partha.movieinfoserviceA.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieid}")
	public Movie geiMovieInfo(@PathVariable("movieid") String movieId)
	{
		List<Movie> movieList = Arrays.asList(
				new Movie("E001","Transformers","English Movie Fiction"),
				new Movie("B003", "Bollywood Movie", "Hindi Bollywood Movie"),
				new Movie("E007", "SkyFall", "Hollywood Movie"),
				new Movie("B008", "Test Hindi", "Hindi Test Movie")
				);
		Movie movieDet = (Movie) movieList.stream().filter(movie -> movie.getMovieId().equalsIgnoreCase(movieId)).findFirst()
                .orElse(null);
		return movieDet;
	}

}
