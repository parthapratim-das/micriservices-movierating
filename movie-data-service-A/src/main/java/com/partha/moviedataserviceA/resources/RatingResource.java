package com.partha.moviedataserviceA.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partha.moviedataserviceA.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@RequestMapping("/{userid}")
	public List<Rating> getRatingData(@PathVariable("userid") String userId)
	{
		List<Rating> ratingsData = Arrays.asList(
				new Rating("ppd","E001",5),
				new Rating("JDJ","E001",4),
				new Rating("agh","B003",4),
				new Rating("agh","E007",3),
				new Rating("agh","B008",5),
				new Rating("ppd","B008",2),
				new Rating("ppd","B003",4),
				new Rating("ppd","E007",2)
				);
		
		List<Rating> userRating = ratingsData.stream().filter(rating -> rating.getUserId().equalsIgnoreCase(userId)).collect(Collectors.toList());
		
		return userRating;
	}

}
