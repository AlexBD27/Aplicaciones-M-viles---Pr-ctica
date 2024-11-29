package com.example.chancay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.chancay.model.Embarcacion;
import com.example.chancay.service.EmbarcacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;





@RestController
public class EmbarcacionController {
    
    @Autowired
    private EmbarcacionService embarcacionService;
    
    @GetMapping("/")
    public List<Embarcacion> index(){
        return embarcacionService.getEmbarcaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Embarcacion> getEmbarcacionById(@PathVariable Integer id) {
        Embarcacion embarcacion = embarcacionService.getEmbarcacion(id);
        if(embarcacion != null){
            return ResponseEntity.ok(embarcacion);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Embarcacion createEmbarcacion(@RequestBody Embarcacion embarcacion) {
        return embarcacionService.createEmbarcacion(embarcacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Embarcacion> updateEmbarcacion(@RequestBody Embarcacion embarcacion, @PathVariable Integer id){

        Embarcacion embarcacionActual = embarcacionService.getEmbarcacion(id);
        if (embarcacionActual != null){
            return ResponseEntity.ok(embarcacionActual);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmbarcacion(@PathVariable Integer id){
        Embarcacion embarcacionActual = embarcacionService.getEmbarcacion(id);
        if (embarcacionActual != null){
            embarcacionService.deleteEmbarcacion(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
