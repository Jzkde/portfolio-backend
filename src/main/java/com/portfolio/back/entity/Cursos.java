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
public class Cursos {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    
    private Long id;
    private String nombre;
    private String organizador;
    private int carga;
    private int anio;
    private String caracter;
    private String certificado;

    public Cursos() {
    }

    public Cursos(String nombre, String organizador, int carga, int anio, String caracter, String certificado) {
        this.nombre = nombre;
        this.organizador = organizador;
        this.carga = carga;
        this.anio = anio;
        this.caracter = caracter;
        this.certificado = certificado;
    }
    
    
    
    
}
