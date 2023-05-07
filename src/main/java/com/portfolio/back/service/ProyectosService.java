/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.Proyectos;
import com.portfolio.back.repository.ProyectosRepository;
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
public class ProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;
    public List<Proyectos> list(){
    return proyectosRepository.findAll();
}
public Optional<Proyectos> getOne (Long id){
    return proyectosRepository.findById(id);
}
public Optional<Proyectos> getByNombre(String nombre){
    return proyectosRepository.findByNombre(nombre);
}
public void save (Proyectos proyectos){
    proyectosRepository.save(proyectos);
}
public void delete (Long id){
    proyectosRepository.deleteById(id);
}
public boolean existById (Long id){
    return proyectosRepository.existsById(id);
}
    
    
    
}
