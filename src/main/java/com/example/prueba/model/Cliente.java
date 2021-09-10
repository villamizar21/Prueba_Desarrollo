package com.example.prueba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Cliente {
	
	
	 @Id
	 @Column(name = "cliente_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer cliente_id;
	 
	 private String cliente_nombre;
	 private int cliente_telefono;
	
	 
	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
		@JsonManagedReference
	    private List<Alquiler> alquilados;

	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nombre, int telefono) {
		super();
		this.cliente_id = id;
		this.cliente_nombre = nombre;
		this.cliente_telefono = telefono;
	}

	
	public Cliente(String nombre, int telefono) {
		super();
		this.cliente_nombre = nombre;
		this.cliente_telefono = telefono;
	}

	
	
	public int getCleinte_id() {
		return cliente_id;
	}

	public void setCleinte_id(Integer cleinte_id) {
		this.cliente_id = cleinte_id;
	}

	public String getCliente_nombre() {
		return cliente_nombre;
	}

	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}

	public int getCliente_telefono() {
		return cliente_telefono;
	}

	public void setCliente_telefono(int cliente_telefono) {
		this.cliente_telefono = cliente_telefono;
	}

	public List<Alquiler> getAlquilados() {
		return alquilados;
	}

	public void setAlquilados(List<Alquiler> alquilados) {
		this.alquilados = alquilados;
	} 
	  
}
