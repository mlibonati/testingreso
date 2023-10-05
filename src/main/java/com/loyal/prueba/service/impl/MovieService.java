package com.loyal.prueba.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loyal.prueba.DTO.MovieResponse;
import com.loyal.prueba.entity.Movie;
import com.loyal.prueba.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String API_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

	@Override
	public List<Movie> getMovieTitles(String searchTitle) {
		List<Movie> movieList = new ArrayList<>();
		int currentPage = 1;

		try {
			while (true) {
				String apiUrl = API_URL + searchTitle + "&page=" + currentPage;

				ResponseEntity<MovieResponse> responseEntity = restTemplate.getForEntity(apiUrl, MovieResponse.class);
				MovieResponse movieResponse = responseEntity.getBody();

				if (movieResponse != null && movieResponse.getData() != null) {
					movieResponse.getData().forEach(movieData -> {
						String title = movieData.getTitle();
						movieList.add(new Movie(title));
					});
				}

				// Verificar si hay más páginas para consultar
				if (currentPage >= movieResponse.getTotalPages()) {
					break;
				}

				// Incrementar la página para la siguiente solicitud
				currentPage++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return movieList;
	}
}