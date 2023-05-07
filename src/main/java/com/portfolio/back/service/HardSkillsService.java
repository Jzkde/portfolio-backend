/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.service;

import com.portfolio.back.entity.HardSkills;
import com.portfolio.back.repository.HardSkillsRepository;
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
public class HardSkillsService {
    @Autowired
    HardSkillsRepository hardSkillsRepository;

public List<HardSkills> list(){
    return hardSkillsRepository.findAll();
}
public Optional<HardSkills> getOne (Long id){
    return hardSkillsRepository.findById(id);
}
public Optional<HardSkills> getByNombre(String nombre){
    return hardSkillsRepository.findByNombre(nombre);
}
public void save (HardSkills hardSkills){
    hardSkillsRepository.save(hardSkills);
}
public void delete (Long id){
    hardSkillsRepository.deleteById(id);
}
public boolean existById (Long id){
    return hardSkillsRepository.existsById(id);
}
}
