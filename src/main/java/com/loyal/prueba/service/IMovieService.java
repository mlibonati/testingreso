package com.loyal.prueba.service;

import com.loyal.prueba.entity.Movie;

import java.util.List;

public interface IMovieService {
  List<Movie> getMovieTitles(String searchTitle);
}
