/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import org.rosa.negocioclinica.NegocioFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import interfaces.INegocioPaciente;

/**
 *
 * @author natsu
 */
@RestController
@RequestMapping("paciente")
public class ControladorPaciente {
       
    @GetMapping("/siguiente")
    public String buscarPacienteSiguiente() {
        
        INegocioPaciente negocio = NegocioFactory.createInstancePaciente();
        String response = negocio.buscarPacienteSiguiente();
        return response;
        
        
    }
    
   
    
}
