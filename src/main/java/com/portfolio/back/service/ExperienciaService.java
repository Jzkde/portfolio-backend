/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.Experiencia;
import com.portfolio.back.repository.ExperienciaRepository;
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
public class ExperienciaService {
@Autowired
    ExperienciaRepository experienciaRepository;

public List<Experiencia> list(){
    return experienciaRepository.findAll();
}
public Optional<Experiencia> getOne (Long id){
    return experienciaRepository.findById(id);
}
public Optional<Experiencia> getByEmpresa(String empresa){
    return experienciaRepository.findByEmpresa(empresa);
}
public void save (Experiencia experiencia){
    experienciaRepository.save(experiencia);
}
public void delete (Long id){
    experienciaRepository.deleteById(id);
}
public boolean existById (Long id){
    return experienciaRepository.existsById(id);
}
}
