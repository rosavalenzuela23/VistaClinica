/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import interfaces.INegocioSesion;
import org.rosa.negocioclinica.NegocioFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
@RequestMapping("sesion")
public class ControladorSesion {
    
    @PostMapping("/registrar")
    public String registrarSesion(@RequestBody String json){
        
        INegocioSesion negocioSesion =  NegocioFactory.createInstanceSesion();
        String response = negocioSesion.registrarSesion(json);
        return response;
    }
}
