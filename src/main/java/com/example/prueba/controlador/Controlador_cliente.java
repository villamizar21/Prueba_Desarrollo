package com.example.prueba.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.interfaces.ICliente;
import com.example.prueba.model.Cliente;
import com.example.prueba.model.Obtener_datos_cliente;



@RestController
@RequestMapping(path="/clientes",method = RequestMethod.POST)
public class Controlador_cliente {
	
	@Autowired 
	private ICliente ICliente;
	
	 @GetMapping(path="/listar")
		public @ResponseBody List<Cliente> listar() {
			return ICliente.findAll();
			
		}
	
	   @PostMapping(path = "/registarcliente")
	    public Map<String, Object> registrar(@RequestBody Cliente cliente, Model model) {
	        
	        	Cliente c= new Cliente(cliente.getCliente_nombre(),cliente.getCliente_telefono());
	        	ICliente.save(c);
	            return respuesta(true, "Se registro el cliente", null);
	    }
		
	   
	   @GetMapping(path = "/{id}")
	    public Map<String, Object> buscarClien(@PathVariable Integer id) {
	         
	        	 Optional<Cliente>  cliente = ICliente.findById(id);
	        	 
	        	 if(cliente.isPresent()) {
	        		 Cliente c = cliente.get();
	        		 return respuesta(true, "Cliente encontrado", c);
	        		 
	        	 }else
	        		 return respuesta(false, "Cliente no encontrado", null);
     
	    }
	 
	   
	    @PutMapping(path = "/edit")
	    public Map<String, Object> editar(@RequestBody Obtener_datos_cliente cliente) {
	
	        	Optional<Cliente> c=  ICliente.findById(cliente.getCliente_id());
	        	
	        	if(c.isPresent()) {
	        		Cliente cliente2= c.get();
	        		if((cliente.getCliente_id() != 0)) {
	        			cliente2.setCleinte_id(cliente.getCliente_id());
	        		}
	        		if(!cliente.getCliente_nombre().isBlank()) {
	        			cliente2.setCliente_nombre(cliente.getCliente_nombre());
	        		}
	        		
	        		if(cliente.getCliente_telefono() != 0) {
	        			cliente2.setCliente_telefono(cliente.getCliente_telefono());
	        		}
	        		
	        		 ICliente.save(cliente2);
	        		 
	        		 return respuesta(true,"Exitosa", null);
	        	}else {
	        		   
	                return respuesta(false, "Cliente no encontrado", null);
	            }
	    }
	 
	    @DeleteMapping(path = "/delete/{id}")
	    public Map<String, Object> borrarCliente(@PathVariable Integer id) {
	  
	    Optional<Cliente> cliente= ICliente.findById(id);
	    if(cliente.isPresent())  {
	    	ICliente.delete(cliente.get());
	    	return respuesta(true, "Se ha eliminado el Registro correctamente", null);
	    }
	    else {
	         return respuesta(false, "Cliente no encontrado", null);
	         }     
	   }
	    
	 public static Map<String, Object> respuesta(boolean status, String msg, Object data) {
	        Map<String, Object> respuesta = new HashMap<>();
	        respuesta.put("msg", msg);
	        respuesta.put("data", data);
	        respuesta.put("status", status);
	        return respuesta;
	    }
}
	