package com.example.prueba.model;

public class Obtener_datos_game {

	private Integer id;
	private String titulo;
	private String protagonista; 
	private String director;
	private String tecnologia;
	private String productor;
	

	public Obtener_datos_game(String titulo, String protagonista, String director, String tecnologia, String productor) {
		super();
		this.titulo = titulo;
		this.protagonista = protagonista;
		this.director = director;
		this.tecnologia = tecnologia;
		this.productor = productor;
	}
	public Obtener_datos_game(Integer id, String titulo, String protagonista, String director, String tecnologia,
			String productor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.protagonista = protagonista;
		this.director = director;
		this.tecnologia = tecnologia;
		this.productor = productor;
	}
	
	public Obtener_datos_game() {
		super();
	}
	
	public String getProductor() {
		return productor;
	}
	public void setProductor(String productor) {
		this.productor = productor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(String portagonista) {
		this.protagonista = portagonista;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	
	
}
