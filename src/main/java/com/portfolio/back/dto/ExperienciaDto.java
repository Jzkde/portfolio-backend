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
public class ExperienciaDto {

    private String empresa;
    private String cargo;
    private String periodo;
    private String descricion; 
    private String logo; 
    

    public ExperienciaDto() {
    }

    public ExperienciaDto(String empresa, String cargo, String periodo, String descricion, String logo) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.periodo = periodo;
        this.descricion = descricion;
        this.logo = logo;
    }
    
}
