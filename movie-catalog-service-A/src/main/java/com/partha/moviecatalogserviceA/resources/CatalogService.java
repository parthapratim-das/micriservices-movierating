package com.partha.moviecatalogserviceA.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.partha.moviecatalogserviceA.models.CatalogItem;
import com.partha.moviecatalogserviceA.models.Movie;
import com.partha.moviecatalogserviceA.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogService {
	
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid")String userId)
	{
		
		RestTemplate restTemplate = new RestTemplate();
		
		//List<Rating> ratings = Arrays.asList(new Rating("E001",3),
		//									 new Rating("B008",4));
		//calling API for movie details
		//restTemplate.getForObject("http://localhost:8083/ratings/ppd", Rating.class);
		
		
		List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
		//catalogItems = Arrays.asList(new CatalogItem("Transforner","English",4),
		//							 new CatalogItem("Death Valley","Hindi",3));
		
		
		//List<Rating> ratings = (List<Rating>) restTemplate.getForObject("http://localhost:8082/ratings/"+userId, Rating.class);
		
		ResponseEntity<List<Rating>> ratingResponse =
		        restTemplate.exchange("http://localhost:8083/ratings/"+userId,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {
		            });
		List<Rating> ratings = ratingResponse.getBody();
		
		catalogItems= ratings.stream().map(rating -> {
			Movie movie = (Movie)restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), movie.getMovieDesc(), rating.getRating());

		}).collect(Collectors.toList());
		
		return catalogItems;
		
	}

}
