package org.generation.italy.controller;

import javax.validation.Valid;

import org.generation.italy.model.Pizza;
import org.generation.italy.service.IngredientiService;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pizze/nuova")
public class PizzaCreateController {
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientiService ingredientiService;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("edit", false);
		model.addAttribute("pizza",new Pizza());
		model.addAttribute("ingredientiList", ingredientiService.findAll());
		return "createPizza";
	}
	
	
	@PostMapping
	
	public String doCreate(@Valid @ModelAttribute("pizza") Pizza formPizza,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "createPizza";
		}
		pizzaService.save(formPizza);
		return"redirect:/pizze";
	}

}
