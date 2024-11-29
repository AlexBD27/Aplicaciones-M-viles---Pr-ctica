package com.example.chancay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chancay.model.Embarcacion;
import com.example.chancay.repository.EmbarcacionRepository;

@Service
public class EmbarcacionService {

    @Autowired
    private EmbarcacionRepository embarcacionRepository;

    public Embarcacion createEmbarcacion(Embarcacion embarcacion){
        return embarcacionRepository.save(embarcacion);
    }

    public List<Embarcacion> getEmbarcaciones(){
        return embarcacionRepository.findAll();
    }

    public Embarcacion getEmbarcacion(Integer id){
        return embarcacionRepository.findById(id).orElse(null);
    }

    public Embarcacion updatEmbarcacion(Integer id, Embarcacion embarcacion){
        Embarcacion embarcacionActual = embarcacionRepository.findById(id).orElse(null);

        if(embarcacionActual != null){
            embarcacionActual.setNombre(embarcacion.getNombre());
            embarcacionActual.setCapacidad(embarcacion.getCapacidad());
            embarcacionActual.setDescripcion(embarcacion.getDescripcion());
            return embarcacionRepository.save(embarcacionActual);
        }
        return null;
    }

    public void deleteEmbarcacion (Integer id){
        embarcacionRepository.deleteById(id);
    }
}
