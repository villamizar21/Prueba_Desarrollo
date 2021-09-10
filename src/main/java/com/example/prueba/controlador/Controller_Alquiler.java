package com.example.prueba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.interfaces.IAlquiler;
import com.example.prueba.model.Alquiler;

@RestController
@RequestMapping(path="/Alquiler")
public class Controller_Alquiler {
	
	
	@Autowired 
	private IAlquiler alquiler;
	
	 @GetMapping(path="/listar")
		public @ResponseBody List<Alquiler> listar() {
			return alquiler.findAll();
			
		}

}
