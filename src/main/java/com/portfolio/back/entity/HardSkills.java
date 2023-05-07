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
public class HardSkills {
    @Id
 @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int grado;
    private String nivel;
    private String logo;

    public HardSkills() {
    }

    public HardSkills(String nombre, int grado, String nivel, String logo) {
        this.nombre = nombre;
        this.grado = grado;
        this.nivel = nivel;
        this.logo = logo;
    }
    
    
    
    
}
