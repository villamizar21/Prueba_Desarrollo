package com.example.prueba.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.model.Venta;

@Repository
public interface IVenta  extends JpaRepository<Venta, Integer> {

}
