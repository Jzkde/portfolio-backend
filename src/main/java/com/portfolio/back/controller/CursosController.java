/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.CursosDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.Cursos;
import com.portfolio.back.service.CursosService;
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
@RequestMapping("api/cursos")
@CrossOrigin
public class CursosController {
    
    @Autowired
    CursosService cursosService;
    
    @GetMapping("/lista")
    public ResponseEntity <List<Cursos>> list(){
        List<Cursos> list = cursosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("detalle/{id}")
    public ResponseEntity <Cursos> getById(@PathVariable("id") Long id){
        if(!cursosService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        Cursos cursos = cursosService.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity <?> create (@RequestBody CursosDto cursosDto){
        if (StringUtils.isBlank(cursosDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE del curso no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(cursosDto.getOrganizador()))        
            return new ResponseEntity (new Mensaje("El ORGANIZADOR del no debe estar en blanco"), HttpStatus.BAD_REQUEST);
         if (cursosDto.getCarga()<0)       
            return new ResponseEntity (new Mensaje("La CARGA horaria debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
         if (StringUtils.isBlank(cursosDto.getCertificado()))        
            return new ResponseEntity (new Mensaje("Debes cargar el CERTIFICADO del curso"), HttpStatus.BAD_REQUEST);
         Cursos cursos = new Cursos (
                cursosDto.getNombre(), 
                cursosDto.getOrganizador(), 
                cursosDto.getCarga(), 
                cursosDto.getAnio(), 
                cursosDto.getCaracter(), 
                cursosDto.getCertificado());
         cursosService.save(cursos);
            return new ResponseEntity (new Mensaje("Curso Cargado"), HttpStatus.OK);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <?> update (@PathVariable ("id") Long id,@RequestBody CursosDto cursosDto){
         if(!cursosService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(cursosDto.getNombre()))        
            return new ResponseEntity (new Mensaje("El NOMBRE del curso no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(cursosDto.getOrganizador()))        
            return new ResponseEntity (new Mensaje("El ORGANIZADOR del no debe estar en blanco"), HttpStatus.BAD_REQUEST);
         if (cursosDto.getCarga()<0)       
            return new ResponseEntity (new Mensaje("La CARGA horaria debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
         if (StringUtils.isBlank(cursosDto.getCertificado()))        
            return new ResponseEntity (new Mensaje("Debes cargar el CERTIFICADO del curso"), HttpStatus.BAD_REQUEST);
         Cursos cursos = cursosService.getOne(id).get();
         cursos.setNombre(cursosDto.getNombre());
         cursos.setOrganizador(cursosDto.getOrganizador());
         cursos.setCarga(cursosDto.getCarga());
         cursos.setAnio(cursosDto.getAnio());
         cursos.setCaracter(cursosDto.getCaracter());
         cursos.setCertificado(cursosDto.getCertificado());
         cursosService.save(cursos);
            return new ResponseEntity (new Mensaje("Curso Modificado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
 public ResponseEntity <?> delete (@PathVariable ("id") Long id){
         if(!cursosService.existById(id))
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        cursosService.delete(id);
        return new ResponseEntity(new Mensaje("Curso Eliminado"), HttpStatus.OK);
         
}

    
    
}
