package com.example.prueba.model;

public class Obtener_datos_cliente {

	private Integer id;
	private String nombre;
	private int telefono;
	
	
	public Obtener_datos_cliente(Integer cliente_id, String cliente_nombre, int cliente_telefono) {
		super();
		this.id = cliente_id;
		this.nombre = cliente_nombre;
		this.telefono = cliente_telefono;		
	}
	
	public Obtener_datos_cliente(String cliente_nombre, int cliente_telefono) {
		super();
		this.nombre = cliente_nombre;
		this.telefono = cliente_telefono;
	}
	

	public Obtener_datos_cliente() {
		super();
	}


	public Integer getCliente_id() {
		return id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.id = cliente_id;
	}
	public String getCliente_nombre() {
		return nombre;
	}
	public void setCliente_nombre(String cliente_nombre) {
		this.nombre = cliente_nombre;
	}
	public int getCliente_telefono() {
		return telefono;
	}
	public void setCliente_telefono(int cliente_telefono) {
		this.telefono = cliente_telefono;
	}
	
	
	
}
