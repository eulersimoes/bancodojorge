/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancodojorge.apirest.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bancodojorge.apirest.domain.model.Cliente;
import java.util.Optional;
/**
 *
 * @author Euler
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
   Optional<Cliente> findByCpf(String cpf);    
   Optional<Cliente> findById(Long id);   
}
