/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.Cursos;
import com.portfolio.back.repository.CursosRepository;
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
public class CursosService {
@Autowired
    CursosRepository cursosRepository;

public List<Cursos> list(){
    return cursosRepository.findAll();
}
public Optional<Cursos> getOne (Long id){
    return cursosRepository.findById(id);
}
public Optional<Cursos> getByNombre(String nombre){
    return cursosRepository.findByNombre(nombre);
}
public void save (Cursos cursos){
    cursosRepository.save(cursos);
}
public void delete (Long id){
    cursosRepository.deleteById(id);
}
public boolean existById (Long id){
    return cursosRepository.existsById(id);
}
    
}
