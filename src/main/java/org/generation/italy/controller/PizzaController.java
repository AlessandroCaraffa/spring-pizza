package org.generation.italy.controller;


import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("pizze", pizzaService.findAll());
		return "pizza";
	}
	
	@GetMapping("/dettagli/{id}")
		public String detail (@PathVariable("id") Integer id,  Model model) {
			model.addAttribute("pizza",pizzaService.getById(id));
			return "pizza/dettagli";
		}
	

}
