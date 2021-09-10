package com.example.prueba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
	
	public Venta() {
		
	}

	public Venta(int numero_venta, int alquiler_id, int cliente_id, Date fecha_entrega) {
		this.numero_venta = numero_venta;
		this.alquiler_id = alquiler_id;
		this.cleinte_id = cliente_id;
		this.fecha_entrega = fecha_entrega;
	}
	public Venta(Integer id, int numero_venta, int alquiler_id, int cliente_id, Date fecha_entrega) {
		super();
		this.venta_id = id;
		this.numero_venta = numero_venta;
		this.alquiler_id = alquiler_id;
		this.cleinte_id = cliente_id;
		this.fecha_entrega = fecha_entrega;
	}
	
	 @Id
	private int venta_id;
	 
	 @Column (name = "numero_venta")
	 private int numero_venta;
	 	 
	 @Column (name = "alquiler_id")
	 private int alquiler_id;
	 
	 @Column (name = "cleinte_id")
	 private int cleinte_id;
	 
	 @Column (name = "fecha_entrega")
	 private Date fecha_entrega;
	 

	public int getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Integer venta_id) {
		this.venta_id = venta_id;
	}

	public int getNumero_venta() {
		return numero_venta;
	}

	public void setNumero_venta(int numero_venta) {
		this.numero_venta = numero_venta;
	}

	public int getAlquiler_id() {
		return alquiler_id;
	}

	public void setAlquiler_id(int alquiler_id) {
		this.alquiler_id = alquiler_id;
	}

	public int getCleinte_id() {
		return cleinte_id;
	}

	public void setCleinte_id(int cleinte_id) {
		this.cleinte_id = cleinte_id;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	 
	 
	 
	

}
