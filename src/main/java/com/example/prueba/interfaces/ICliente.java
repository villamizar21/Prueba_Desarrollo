package com.example.prueba.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.model.Cliente;


@Repository
public interface ICliente  extends JpaRepository<Cliente, Integer> {

	
}
