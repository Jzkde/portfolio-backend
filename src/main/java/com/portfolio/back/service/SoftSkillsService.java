/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.SoftSkills;
import com.portfolio.back.repository.SoftSkillsRepository;
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
public class SoftSkillsService {
    
    @Autowired
    SoftSkillsRepository softSkillsRepository;

public List<SoftSkills> list(){
    return softSkillsRepository.findAll();
}
public Optional<SoftSkills> getOne (Long id){
    return softSkillsRepository.findById(id);
}
public Optional<SoftSkills> getByNombre(String nombre){
    return softSkillsRepository.findByNombre(nombre);
}
public void save (SoftSkills softSkills){
    softSkillsRepository.save(softSkills);
}
public void delete (Long id){
    softSkillsRepository.deleteById(id);
}
public boolean existById (Long id){
    return softSkillsRepository.existsById(id);
}
}

    

