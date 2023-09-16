/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancodojorge.apirest.infrastructure.Services;

import br.com.bancodojorge.apirest.domain.model.Cliente;
import br.com.bancodojorge.apirest.infrastructure.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euler
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findClienteById(Long id) throws Exception {
        return this.clienteRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public Cliente findClienteByCpf(String cpf) throws Exception {
        return this.clienteRepository.findByCpf(cpf).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }
    
    public void saveCliente(Cliente cliente)
    {
        this.clienteRepository.save(cliente);
    }

}
