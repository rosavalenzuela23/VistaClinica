/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import interfaces.INegocioEmpleado;
import java.util.HashMap;
import java.util.Map;
import org.rosa.negocioclinica.NegocioEmpleado;
import org.rosa.negocioclinica.NegocioFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
       
}
