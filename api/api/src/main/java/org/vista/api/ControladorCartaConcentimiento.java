/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vista.api;

import java.io.IOException;
import org.rosa.negocioclinica.NegocioPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author natsu
 */
public class ControladorCartaConcentimiento {
    
    @PostMapping("/")
    public void guardarCarta(@RequestPart("file-data") MultipartFile archivo, @RequestBody String body) throws IOException {
        var negocioPaciente = new NegocioPaciente();
        negocioPaciente.agregarCartaConcentimiento(body, archivo.getBytes());
    }
    
}
