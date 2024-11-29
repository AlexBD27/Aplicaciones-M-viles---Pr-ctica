package com.example.chancay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chancay.model.Embarcacion;

@Repository
public interface EmbarcacionRepository extends JpaRepository<Embarcacion, Integer> {

    
    
}
