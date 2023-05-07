/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.HardSkillsDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.HardSkills;
import com.portfolio.back.service.HardSkillsService;
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
@RequestMapping("api/hardskills")
@CrossOrigin
public class HardSkillsController {
    @Autowired
    HardSkillsService hardSkillsService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<HardSkills>> list(){
        List<HardSkills> list = hardSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("detalle/{id}")
    public ResponseEntity <HardSkills> getById(@PathVariable("id") Long id){
        if(!hardSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        HardSkills hardSkills = hardSkillsService.getOne(id).get();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity <?> create (@RequestBody HardSkillsDto hardSkillsDto){
        if (StringUtils.isBlank(hardSkillsDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE de la habilidad no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (hardSkillsDto.getGrado()<0)       
            return new ResponseEntity (new Mensaje("El GRADO de dominio debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(hardSkillsDto.getNivel()))        
            return new ResponseEntity (new Mensaje("El NIVEL de dominio no debe estar en blanco"), HttpStatus.BAD_REQUEST);
         if (StringUtils.isBlank(hardSkillsDto.getLogo()))        
            return new ResponseEntity (new Mensaje("Debes cargar el LOGO de la habilidad"), HttpStatus.BAD_REQUEST);
         HardSkills hardSkills = new HardSkills (
                hardSkillsDto.getNombre(), 
                hardSkillsDto.getGrado(), 
                hardSkillsDto.getNivel(), 
                hardSkillsDto.getLogo());
         hardSkillsService.save(hardSkills);
            return new ResponseEntity (new Mensaje("Hablidad Cargada"), HttpStatus.OK);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <?> update (@PathVariable ("id") Long id,@RequestBody HardSkillsDto hardSkillsDto){
         if(!hardSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
       if (StringUtils.isBlank(hardSkillsDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE de la habilidad no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (hardSkillsDto.getGrado()<0)       
            return new ResponseEntity (new Mensaje("El GRADO de dominio debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(hardSkillsDto.getNivel()))        
            return new ResponseEntity (new Mensaje("El NIVEL de dominio no debe estar en blanco"), HttpStatus.BAD_REQUEST);
         if (StringUtils.isBlank(hardSkillsDto.getLogo()))        
            return new ResponseEntity (new Mensaje("Debes cargar el LOGO de la habilidad"), HttpStatus.BAD_REQUEST);
         HardSkills hardSkills = hardSkillsService.getOne(id).get();
         hardSkills.setNombre(hardSkillsDto.getNombre());
         hardSkills.setGrado(hardSkillsDto.getGrado());
         hardSkills.setNivel(hardSkillsDto.getNivel());
         hardSkills.setLogo(hardSkillsDto.getLogo());
      
         hardSkillsService.save(hardSkills);
            return new ResponseEntity (new Mensaje("Habilidad Modificada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
 public ResponseEntity <?> delete (@PathVariable ("id") Long id){
         if(!hardSkillsService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        hardSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
         
}

    
    
}