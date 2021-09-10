package com.example.prueba.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.model.Juegos;

@Repository
public interface IJuegos  extends JpaRepository<Juegos, Integer> {

}
