/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import interfaces.INegocio;
import org.rosa.negocioclinica.NegocioFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natsu
 */
@RestController
public class ControladorPaciente {
    
    private final String endpoint = "paciente/";
    
    @GetMapping(endpoint)
    public String getPacientes() {
        
        INegocio negocio = NegocioFactory.createInstance();
        
        
        return negocio.getObject();
    }
    
}
