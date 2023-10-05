package com.loyal.prueba.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.loyal.prueba.controller.Movie;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
	public List<Movie> getMovieTitles(String searchTitle) {
		List<Movie> movieList = new ArrayList<>();
		int currentPage = 1;

		try {
			while (true) {
				// Construir la URL de la solicitud
				String apiUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + searchTitle + "&page=" + currentPage;
				URL url = new URL(apiUrl);

				// Realizar la solicitud HTTP
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");

				// Leer la respuesta JSON
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();

				// Analizar la respuesta JSON
				JSONObject jsonResponse = new JSONObject(response.toString());
				JSONParser movies = jsonResponse.getJSONArray("data");

				// Extraer los títulos de las películas
				for (int i = 0; i < movies.(); i++) {
					JSONPObject movieJson = movies.getJSONObject(i);
					String title = movieJson.getString("Title");
					movieList.add(new Movie(title));
				}

				// Verificar si hay más páginas para consultar
				int totalPages = jsonResponse.getInt("total_pages");
				if (currentPage >= totalPages) {
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