/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.AcercaDe;
import com.portfolio.back.repository.AcercaDeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jzkd
 */
@Service
@Transactional
public class AcercaDeService {
    
    @Autowired
    AcercaDeRepository acercaDeRepository;

public List<AcercaDe> list(){
    return acercaDeRepository.findAll();
}
public Optional<AcercaDe> getOne (Long id){
    return acercaDeRepository.findById(id);
}
public Optional<AcercaDe> getByNombre(String nombre){
    return acercaDeRepository.findByNombre(nombre);
}
public void save (AcercaDe acercaDe){
    acercaDeRepository.save(acercaDe);
}
public void delete (Long id){
    acercaDeRepository.deleteById(id);
}
public boolean existById (Long id){
    return acercaDeRepository.existsById(id);
}

    
}
