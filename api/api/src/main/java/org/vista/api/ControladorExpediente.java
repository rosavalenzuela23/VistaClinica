/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;
import interfaces.INegocioExpediente;
import org.rosa.negocioclinica.NegocioFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
@RequestMapping("expediente")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class ControladorExpediente {
    
    /**
     * TODO: CHANGE THE idPsicologo por IdExpediente
     * @param idPsicologo
     * @return 
     */
    @GetMapping("/{idPsicologo}")
    public String buscarExpedientes(@PathVariable Long idPsicologo){
        
        INegocioExpediente negocioExpediente = NegocioFactory.createInstanceExpediente();
        String json =  negocioExpediente.buscarExpedientes(idPsicologo);
        
       
        return json;
    }
    
    @GetMapping("/paciente/{idPaciente}")
    public String buscarExpediente(@PathVariable Long idPaciente) {
        var negocioExpediente = NegocioFactory.createInstanceExpediente();
        return negocioExpediente.obtenerExpedientePorPacienteId(idPaciente);
    }
    
    @PostMapping("/registrar")
    public String registrarExpediente(@RequestBody String json){
        INegocioExpediente negocioExpediente = NegocioFactory.createInstanceExpediente();
        String response = negocioExpediente.registrarExpediente(json);
        
        return response;
    }
    
    
    
}
