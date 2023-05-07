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
public class AcercaDeDto {
    
       private String nombre;
       private String titulo;
       private String email;
       private String descricion;
       private String imagen;

    public AcercaDeDto() {
    }

    public AcercaDeDto(String nombre, String titulo, String email, String descricion, String imagen) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.email = email;
        this.descricion = descricion;
        this.imagen = imagen;
    }
       
       
       
    
}
