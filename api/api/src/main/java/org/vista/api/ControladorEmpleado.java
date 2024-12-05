/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import interfaces.INegocioEmpleado;
import interfaces.INegocioPsicologo;
import interfaces.INegocioAdministrador;
import interfaces.INegocioRecepcionista;
import java.util.HashMap;
import java.util.Map;
import org.rosa.negocioclinica.NegocioEmpleado;
import org.rosa.negocioclinica.NegocioPsicologo;
import org.rosa.negocioclinica.NegocioAdministrador;
import org.rosa.negocioclinica.NegocioRecepcionista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
@RequestMapping("empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorEmpleado {
    
    /**
     * 
     * @param
     * @return 
     */
    @PostMapping("/")
    public ResponseEntity<Object> obtenerEmpleado(@RequestBody String json) throws Exception{
        try{
            INegocioEmpleado ne = new NegocioEmpleado();
            return ResponseEntity.ok(ne.obtenerEmpleado(json));
        }catch(Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", HttpStatus.UNAUTHORIZED);
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse); 
        }
    }
    
    @PostMapping("Recepcionista")
    public String registrarRecepcionista(@RequestBody String json){
        INegocioRecepcionista nr = new NegocioRecepcionista();
        return nr.registrarRecepcionista(json);  
    }
    
    @PostMapping("Psicologo")
    public String registrarPsicologo(@RequestBody String json){
        
        INegocioPsicologo np = new NegocioPsicologo();
        return np.registrarPsicologo(json);
        
    }
    
    @PostMapping("Administrador")
    public String registrarAdministrador(@RequestBody String json){
        INegocioAdministrador na = new NegocioAdministrador();
        return na.registrarAdministrador(json);
    }
    
    @GetMapping("all")
    public String obtenerEmpleados(){
        INegocioEmpleado ne = new NegocioEmpleado();
        return ne.obtenerEmpleados();
    }
    
    @PutMapping("actualizar/Psicologo")
    public String actualizarPsicologo(@RequestBody String json){
        INegocioPsicologo np = new NegocioPsicologo();
        return np.actualizarPsicologo(json);
    }
    
    @PutMapping("actualizar/Administrador")
    public String actualizarAdministrador(@RequestBody String json){
        INegocioAdministrador na = new NegocioAdministrador();
        return na.actualizarAdministrador(json);
    }
    
    @PutMapping("actualizar/Recepcionista")
    public String actualizarRecepcionista(@RequestBody String json){
        INegocioRecepcionista nr = new NegocioRecepcionista();
        return nr.actualizarRecepcionista(json);
    }
    
    @PutMapping("eliminar")
    public String eliminarEmpleado(@RequestBody String json){
        INegocioEmpleado ne = new NegocioEmpleado();
        return ne.eliminarEmpleado(json);
    }
   
    
   
       
}
