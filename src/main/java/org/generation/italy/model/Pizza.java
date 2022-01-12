package org.generation.italy.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@OrderBy("name")
	
	private Integer id;	
	
	@NotNull(message="Inserire un nome")
	@NotEmpty(message="Inserire un nome")
	private String name;
	private String descrizione;
	@NotNull(message="Inserire il prezzo")
	@Positive(message="Il prezzo deve essere superiore a 0€")
	private BigDecimal prezzo;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	

}
