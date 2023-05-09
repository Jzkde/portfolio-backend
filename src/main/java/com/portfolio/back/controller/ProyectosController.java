/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.ProyectosDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.Proyectos;
import com.portfolio.back.service.ProyectosService;
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
@RequestMapping("api/proyectos")
@CrossOrigin
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") Long id) {
        if (!proyectosService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto) {
        if (StringUtils.isBlank(proyectosDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El NOMBRE del proyecto no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectosDto.getSolicitante())) {
            return new ResponseEntity(new Mensaje("El NOMBRE del solicitante no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectosDto.getDescricion())) {
            return new ResponseEntity(new Mensaje("Debes cargar un resumen del proyecto"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(
                proyectosDto.getNombre(),
                proyectosDto.getSolicitante(),
                proyectosDto.getDescricion(),
                proyectosDto.getImagen(),
                proyectosDto.getAnio(),
                proyectosDto.getProy(),
                proyectosDto.getRepo());

        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto o Practica Creada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProyectosDto proyectosDto
    ) {
        if (!proyectosService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(proyectosDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El NOMBRE del proyecto no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectosDto.getSolicitante())) {
            return new ResponseEntity(new Mensaje("El NOMBRE del solicitante no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectosDto.getDescricion())) {
            return new ResponseEntity(new Mensaje("Debes cargar un resumen del proyecto"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setSolicitante(proyectosDto.getSolicitante());
        proyectos.setDescricion(proyectosDto.getDescricion());
        proyectos.setImagen(proyectosDto.getImagen());
        proyectos.setAnio(proyectosDto.getAnio());
        proyectos.setProy(proyectosDto.getProy());
        proyectos.setRepo(proyectosDto.getRepo());

        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto o Practica Modificada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id
    ) {
        if (!proyectosService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto o Practica Eliminada"), HttpStatus.OK);

    }

}
