/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bancodojorge.apirest.infrastructure.repository;


import br.com.bancodojorge.apirest.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Euler
 */
public interface ContaRepository  extends JpaRepository<Conta, Long>{
    
}
