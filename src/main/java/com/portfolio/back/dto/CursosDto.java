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
public class CursosDto {
    
    private String nombre;
    private String organizador;
    private int carga;
    private int anio;
    private String caracter;
    private String certificado;

    public CursosDto() {
    }

    public CursosDto(String nombre, String organizador, int carga, int anio, String caracter, String certificado) {
        this.nombre = nombre;
        this.organizador = organizador;
        this.carga = carga;
        this.anio = anio;
        this.caracter = caracter;
        this.certificado = certificado;
    }
    
}
