package org.generation.italy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Ingredienti {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	
	 private Integer id;	
	
	@NotNull
	@NotEmpty
	private String ingredientiNome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngredientiNome() {
		return ingredientiNome;
	}

	public void setIngredientiNome(String ingredientiNome) {
		this.ingredientiNome = ingredientiNome;
	}
	
	

}
