/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.back.repository;

import com.portfolio.back.entity.SoftSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jzkd
 */
@Repository
public interface SoftSkillsRepository extends JpaRepository< SoftSkills, Long>{
    
    Optional < SoftSkills> findByNombre (String nombre);
}
