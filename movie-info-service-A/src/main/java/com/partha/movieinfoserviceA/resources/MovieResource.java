package com.partha.movieinfoserviceA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partha.movieinfoserviceA.models.Movie;
import com.partha.movieinfoserviceA.repositories.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping("/{movieid}")
	public Movie geiMovieInfo(@PathVariable("movieid") String movieId)
	{
		
		//Dummy movie data population - commented out for JPA implementation
		/*List<Movie> movieList = Arrays.asList(
				new Movie("E001","Transformers","English Movie Fiction"),
				new Movie("B003", "Bollywood Movie", "Hindi Bollywood Movie"),
				new Movie("E007", "SkyFall", "Hollywood Movie"),
				new Movie("B008", "Test Hindi", "Hindi Test Movie")
				);*/
		List<Movie> movieList = movieRepository.findAll();
		Movie movieDet = (Movie) movieList.stream().filter(movie -> movie.getMovieId().equalsIgnoreCase(movieId)).findFirst()
                .orElse(null);
		return movieDet;
	}

}
