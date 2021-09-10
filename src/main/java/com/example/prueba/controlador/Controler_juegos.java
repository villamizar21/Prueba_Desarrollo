package com.example.prueba.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.interfaces.IJuegos;
import com.example.prueba.model.Obtener_datos_game;
import com.example.prueba.model.Juegos;

@RestController
@RequestMapping(path="/juegos")
public class Controler_juegos {
	
	@Autowired 
	private IJuegos games;
	
	 @GetMapping(path="/listar")
		public @ResponseBody List<Juegos> listar() {
			return games.findAll();
			
		}
	
	 @PostMapping(path = "/Registrar_videojuego")
	    public Map<String, Object> registrarCliente(@RequestBody Obtener_datos_game game) {
	       
	        	Juegos c= new Juegos(game.getId(),game.getDirector(),game.getProtagonista(),game.getTecnologia(),game.getTitulo(),game.getProductor());
	   	          games.save(c);
	            return respuesta(true, "El juego se ha registro exitoso", null);
	        	
	    }
	 
	 
	   @DeleteMapping(path = "/delete/{id}")
	    public Map<String, Object> borrarCliente(@PathVariable Integer id) {
	  
	    Optional<Juegos> juego= games.findById(id);
	    if(juego.isPresent())  {
	    	games.delete(juego.get());
	    	return respuesta(true, "Se ha eliminado el Registro correctamente", null);
	    }
	    else {
	         return respuesta(false, "Game no encontrado", null);
	         }     
	   }
	   
	   
	   
	    @PutMapping(path = "/editar_juego")
	    public Map<String, Object> editar(@RequestBody Obtener_datos_game game) {
	
	        	Optional<Juegos> juego=  games.findById(game.getId());
	        	
	        	if(juego.isPresent()) {
	        		Juegos j= juego.get();
	        		
	        		if((game.getId() != 0)) {
	        			j.setJuegos_id(game.getId());
	        		}
	        		if(!game.getTitulo().isBlank()) {
	        			j.setTitulo(game.getTitulo());
	        		}
	        		if(game.getProtagonista().isBlank()) {
	        			j.setProtagonista(game.getProtagonista());
	        		}
	        		if(game.getDirector().isBlank()) {
	        			j.setDirector(game.getDirector());
	        		}
	        		if(game.getTecnologia().isBlank()) {
	        			j.setTecnologia(game.getTecnologia());
	        		}
	        		if(game.getProductor().isBlank()) {
	        			j.setProductor(game.getProductor());
	        		}
	        		
	        		 games.save(j);
	        		 
	        		 return respuesta(true,"Se ha editado Exitosamente", null);
	        	}else {
	        		   
	                return respuesta(false, "Game no encontrado", null);
	            }
	    }
	    
	    @GetMapping(path = "/{id}")
	    public Map<String, Object> buscarClien(@PathVariable Integer id) {
	         
	        	 Optional<Juegos>  game = games.findById(id);
	        	 
	        	 if(game.isPresent()) {
	        		 Juegos j = game.get();
	        		 return respuesta(true, "El juego que buscas se ha encontrado", j);
	        		 
	        	 }else
	        		 return respuesta(false, "El juego que buscas no se ha encontrado", null);
     
	    }
	 
	 public static Map<String, Object> respuesta(boolean status, String msg, Object data) {
	        Map<String, Object> respuesta = new HashMap<>();
	        respuesta.put("msg", msg);
	        respuesta.put("data", data);
	        respuesta.put("status", status);
	        return respuesta;
	    }

}
