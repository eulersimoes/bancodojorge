/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancodojorge.apirest.infrastructure.services;

import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.domain.exception.ClienteNotFoundException;
import br.com.bancodojorge.apirest.domain.model.Cliente;
import br.com.bancodojorge.apirest.domain.util.ClienteUtil;
import br.com.bancodojorge.apirest.infrastructure.repository.ClienteRepository;
import java.util.List;

import br.com.bancodojorge.apirest.infrastructure.spring.assembler.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euler
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private Assembler assembler;

    public Cliente findClienteById(Long id) throws Exception {
        return this.clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public Cliente findClienteByCpf(String cpf) throws Exception {
        return this.clienteRepository.findByCpf(cpf).orElseThrow(() -> new Exception());
    }
    
    public List<ClienteDTO> listarClientes()
    {
        return assembler.from(this.clienteRepository.findAll(), ClienteDTO.class);
        //return this.clienteRepository.findAll();
    }

    @Override
    public void massClienteInsert(Integer quantidade) {
        for (int i =0; i<quantidade;i++)
        {
           Cliente c = ClienteUtil.gerarClienteAleatorio();
           saveCliente (c);
           System.out.println("Cliente Gerado: "+ c.getNome());
        }
    }

    public void saveCliente(Cliente cliente)
    {
        this.clienteRepository.save(cliente);
    }

}
