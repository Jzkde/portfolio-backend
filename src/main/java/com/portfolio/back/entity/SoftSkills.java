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
public class SoftSkills {
    @Id
 @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int grado;

    public SoftSkills() {
    }

    public SoftSkills(String nombre, int grado) {
        this.nombre = nombre;
        this.grado = grado;
    }
    
    
}
