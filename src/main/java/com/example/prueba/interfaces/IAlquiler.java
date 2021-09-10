package com.example.prueba.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.model.Alquiler;



@Repository
public interface IAlquiler  extends JpaRepository<Alquiler, Integer> {

}
