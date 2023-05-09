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
public class ProyectosDto {

    private String nombre;
    private String solicitante;
    private String descricion;
    private String imagen;
    private int anio;
    private String proy;
    private String repo;

    public ProyectosDto() {
    }

    public ProyectosDto(String nombre, String solicitante, String descricion, String imagen, int anio, String proy, String repo) {
        this.nombre = nombre;
        this.solicitante = solicitante;
        this.descricion = descricion;
        this.imagen = imagen;
        this.anio = anio;
        this.proy = proy;
        this.repo = repo;
    }

    
    
    
    
}