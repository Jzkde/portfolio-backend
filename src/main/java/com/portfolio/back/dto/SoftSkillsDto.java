/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jzkd
 */
@Setter @Getter
public class SoftSkillsDto {
    
    private String nombre;
    private int grado;
   
    public SoftSkillsDto() {
    }

    public SoftSkillsDto(String nombre, int grado) {
        this.nombre = nombre;
        this.grado = grado;
    }
    
    
}
