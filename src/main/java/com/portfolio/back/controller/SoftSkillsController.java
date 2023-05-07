/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.SoftSkillsDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.SoftSkills;
import com.portfolio.back.service.SoftSkillsService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jzkd
 */
@RestController
@RequestMapping("api/softskills")
@CrossOrigin
public class SoftSkillsController {
 @Autowired
    SoftSkillsService softSkillsService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<SoftSkills>> list(){
        List<SoftSkills> list = softSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("detalle/{id}")
    public ResponseEntity <SoftSkills> getById(@PathVariable("id") Long id){
        if(!softSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        SoftSkills softSkills = softSkillsService.getOne(id).get();
        return new ResponseEntity(softSkills, HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity <?> create (@RequestBody SoftSkillsDto softSkillsDto){
        if (StringUtils.isBlank(softSkillsDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE de la habilidad no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (softSkillsDto.getGrado()<0)       
            return new ResponseEntity (new Mensaje("El GRADO de dominio debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
        SoftSkills softSkills = new SoftSkills (
                softSkillsDto.getNombre(), 
                softSkillsDto.getGrado()    );
         softSkillsService.save(softSkills);
            return new ResponseEntity (new Mensaje("Hablidad Cargada"), HttpStatus.OK);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <?> update (@PathVariable ("id") Long id,@RequestBody SoftSkillsDto softSkillsDto){
         if(!softSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
       if (StringUtils.isBlank(softSkillsDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE de la habilidad no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (softSkillsDto.getGrado()<0)       
            return new ResponseEntity (new Mensaje("El GRADO de dominio debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
         SoftSkills softSkills = softSkillsService.getOne(id).get();
         softSkills.setNombre(softSkillsDto.getNombre());
         softSkills.setGrado(softSkillsDto.getGrado());
          
         softSkillsService.save(softSkills);
            return new ResponseEntity (new Mensaje("Hibilidad Modificada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
 public ResponseEntity <?> delete (@PathVariable ("id") Long id){
         if(!softSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        softSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
         
}

    
}
