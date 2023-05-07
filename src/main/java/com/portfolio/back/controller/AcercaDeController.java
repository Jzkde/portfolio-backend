/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.AcercaDeDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.AcercaDe;
import com.portfolio.back.service.AcercaDeService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("api/acercade")
@CrossOrigin

public class AcercaDeController {
    
     @Autowired
    AcercaDeService acercaDeService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<AcercaDe>> list(){
        List<AcercaDe> list = acercaDeService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("detalle/{id}")
    public ResponseEntity <AcercaDe> getById(@PathVariable("id") Long id){
        if(!acercaDeService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        AcercaDe acercaDe = acercaDeService.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity <?> create (@RequestBody AcercaDeDto acercaDeDto){
         if (StringUtils.isBlank(acercaDeDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getTitulo()))        
            return new ResponseEntity (new Mensaje("El TITULO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getEmail()))        
            return new ResponseEntity (new Mensaje("Debes cargar un e-Mail"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getDescricion()))        
            return new ResponseEntity (new Mensaje("Debes tener una brebe descripcion de ti mismo"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getImagen()))        
            return new ResponseEntity (new Mensaje("Debes tener una imagen de perfil"), HttpStatus.BAD_REQUEST);
         AcercaDe acercaDe = new AcercaDe (
                acercaDeDto.getNombre(), 
                acercaDeDto.getTitulo(), 
                acercaDeDto.getEmail(), 
                acercaDeDto.getDescricion(), 
                acercaDeDto.getImagen());
    acercaDeService.save(acercaDe);
            return new ResponseEntity (new Mensaje("Perfil Creado"), HttpStatus.OK);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <?> update (@PathVariable ("id") Long id,@RequestBody AcercaDeDto acercaDeDto){
         if(!acercaDeService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(acercaDeDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getTitulo()))        
            return new ResponseEntity (new Mensaje("El TITULO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getEmail()))        
            return new ResponseEntity (new Mensaje("Debes cargar un e-Mail"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getDescricion()))        
            return new ResponseEntity (new Mensaje("Debes tener una brebe descripcion de ti mismo"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(acercaDeDto.getImagen()))        
            return new ResponseEntity (new Mensaje("Debes tener una imagen de perfil"), HttpStatus.BAD_REQUEST);
         AcercaDe acercaDe = acercaDeService.getOne(id).get();
         acercaDe.setNombre(acercaDeDto.getNombre());
         acercaDe.setTitulo(acercaDeDto.getTitulo());
         acercaDe.setEmail(acercaDeDto.getEmail());
         acercaDe.setDescricion(acercaDeDto.getDescricion());
         acercaDe.setImagen(acercaDeDto.getImagen());
        acercaDeService.save(acercaDe);
            return new ResponseEntity (new Mensaje("Perfil Modificado"), HttpStatus.OK);
    }
    
      
    
}
