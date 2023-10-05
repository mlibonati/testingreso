package com.loyal.prueba.controller;

import com.loyal.prueba.service.impl.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class HomeController {

	private MovieService Service;
	@GetMapping("")
	public String home() {
		return "index";
	}
}


