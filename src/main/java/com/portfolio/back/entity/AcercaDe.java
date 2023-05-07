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
public class AcercaDe {
     @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
     
     
       private Long id;
       private String nombre;
       private String titulo;
       private String email;
       private String descricion;
       private String imagen;

    public AcercaDe() {
    }

    public AcercaDe(String nombre, String titulo, String email, String descricion, String imagen) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.email = email;
        this.descricion = descricion;
        this.imagen = imagen;
    }
       
       
     
     
    
}
