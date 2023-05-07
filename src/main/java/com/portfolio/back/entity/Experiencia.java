/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jzkd
 */
@Getter @Setter
@Entity
public class Experiencia {
 @Id
 @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String empresa;
    private String cargo;
    private String periodo;
    private String descricion;
    private String logo;

    public Experiencia() {
    }

    public Experiencia(String empresa, String cargo, String periodo, String descricion, String logo) {
        
        this.empresa = empresa;
        this.cargo = cargo;
        this.periodo = periodo;
        this.descricion = descricion;
        this.logo = logo;
    } 
    
}
