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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientiService ingredientiService;
	
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
	
	@GetMapping("/modifica/{id}")
	public String edit(@PathVariable ("id") Integer id,Model model) {
		model.addAttribute("edit", true);
		model.addAttribute("pizza", pizzaService.getById(id)); 
		model.addAttribute("ingredientiList", ingredientiService.findAll());
		return "createPizza";
		
	}
	
	@PostMapping("/modifica/{id}")
	public String doUpdate(@Valid @ModelAttribute("pizza") Pizza formPizza ,BindingResult bindingResult,Model model ) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("ingredientiList", ingredientiService.findAll());
			return "createPizza";
		}
		pizzaService.save(formPizza); 
		return "redirect:/pizze";
	}
	
	@GetMapping("/cancella/{id}")
	public String doDelete(Model model, @PathVariable ("id") Integer id)  {
		pizzaService.deleteById(id);
		return"redirect:/pizze";
	}
	

}
