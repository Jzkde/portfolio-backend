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
public class HardSkillsDto {
 
    private String nombre;
    private int grado;
    private String nivel;
    private String logo;

    public HardSkillsDto() {
    }

    public HardSkillsDto(String nombre, int grado, String nivel, String logo) {
        this.nombre = nombre;
        this.grado = grado;
        this.nivel = nivel;
        this.logo = logo;
    }
    
    
}
