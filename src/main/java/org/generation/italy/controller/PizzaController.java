package org.generation.italy.controller;

import org.generation.italy.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("pizze", pizzaRepository.findAll());
		return "pizza";
	}

}
