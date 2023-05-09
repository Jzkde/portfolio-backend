/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.controller;

import com.portfolio.back.dto.ExperienciaDto;
import com.portfolio.back.dto.Mensaje;
import com.portfolio.back.entity.Experiencia;
import com.portfolio.back.service.ExperienciaService;
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
@RequestMapping("api/experiencia")
@CrossOrigin
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!experienciaService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getEmpresa())) {
            return new ResponseEntity(new Mensaje("La EMPRESA no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getCargo())) {
            return new ResponseEntity(new Mensaje("El CARGO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getPeriodo())) {
            return new ResponseEntity(new Mensaje("El PERIODO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(
                experienciaDto.getEmpresa(),
                experienciaDto.getCargo(),
                experienciaDto.getPeriodo(),
                experienciaDto.getDescricion(),
                experienciaDto.getLogo());

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Laboral Cargada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaDto experienciaDto) {
        if (!experienciaService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(experienciaDto.getEmpresa())) {
            return new ResponseEntity(new Mensaje("La EMPRESA no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getCargo())) {
            return new ResponseEntity(new Mensaje("El CARGO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getPeriodo())) {
            return new ResponseEntity(new Mensaje("El PERIODO no debe estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setEmpresa(experienciaDto.getEmpresa());
        experiencia.setCargo(experienciaDto.getCargo());
        experiencia.setPeriodo(experienciaDto.getPeriodo());
        experiencia.setDescricion(experienciaDto.getDescricion());
        experiencia.setLogo(experienciaDto.getLogo());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Laboral Modificada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!experienciaService.existById(id)) {
            return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia Laboral Eliminada"), HttpStatus.OK);

    }

}
