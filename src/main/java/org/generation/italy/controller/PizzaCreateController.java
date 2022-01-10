package org.generation.italy.controller;

import org.generation.italy.model.Pizza;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pizze/nuova")
public class PizzaCreateController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("pizza",new Pizza());
		return "createPizza";
	}
	
	
	@PostMapping
	public String doCreate(@ModelAttribute("pizza") Pizza formPizza) {
		pizzaService.save(formPizza);
		return"redirect:/pizze";
	}

}
