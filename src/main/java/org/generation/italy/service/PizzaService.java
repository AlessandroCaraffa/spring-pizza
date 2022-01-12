package org.generation.italy.service;

import java.util.List;

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
	
	public List<Pizza> findAll(){
		return pizzaRepository.findAll();
	}
 	
	public Pizza getById (Integer id ) {
		return pizzaRepository.getById(id);
	}
	public Pizza update(Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
	public void deleteById (Integer id) {
		pizzaRepository.deleteById(id);
	}

}
