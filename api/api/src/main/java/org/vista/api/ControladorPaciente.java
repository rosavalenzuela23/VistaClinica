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
import org.rosa.negocioclinica.NegocioPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author natsu
 */
@RestController
@RequestMapping("paciente")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPaciente {
       
    @GetMapping("/siguiente")
    public String buscarPacienteSiguiente() {
        
        INegocioPaciente negocio = NegocioFactory.createInstancePaciente();
        String response = negocio.buscarPacienteSiguiente();
        return response;
        
        
    }
    
    @GetMapping("/")
    public String obtenerPacientePsicologo(@RequestParam("id") Long id) {
        
        INegocioPaciente negocio = new NegocioPaciente();
        
        return negocio.getPacientesPsicologo(id);
    }

    @GetMapping("/carta")
    public String obtenerPacientePsicologo(@RequestParam("carta") Boolean tieneCarta) {
        INegocioPaciente negocio = new NegocioPaciente();

        return negocio.obtenerPacientesSinCarta();
    }
    
    @PostMapping("/carta")
    public String guardarCartaConcentimiento(@RequestPart("file") MultipartFile file, @RequestParam("paciente") String json) {
        INegocioPaciente negocio = new NegocioPaciente();
        
        try {
            negocio.agregarCartaConcentimiento(json, file.getBytes());
        } catch (Exception e) {
            System.out.println("en la api");
            e.printStackTrace();
        }
        
        
        
        return "{}";
    }

}
