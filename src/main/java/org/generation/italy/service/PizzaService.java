package org.generation.italy.service;

import org.generation.italy.model.Pizza;
import org.generation.italy.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	public Pizza save(Pizza pizza) {
		return pizzaRepository.save(pizza);
		
	}

}
