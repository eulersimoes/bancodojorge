/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancodojorge.apirest.infrastructure.services.impl;

import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.domain.exception.ClienteNotFoundException;
import br.com.bancodojorge.apirest.domain.model.Cliente;
import br.com.bancodojorge.apirest.domain.util.ClienteUtil;
import br.com.bancodojorge.apirest.infrastructure.repository.ClienteRepository;
import br.com.bancodojorge.apirest.infrastructure.services.ClienteService;
import java.util.List;

import br.com.bancodojorge.apirest.infrastructure.spring.assembler.Assembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Euler
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    Logger logger = LoggerFactory.getLogger(ClienteService.class);

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
        logger.info("Listar Clientes");
        return assembler.from(this.clienteRepository.findAll(), ClienteDTO.class);
        //return this.clienteRepository.findAll();
    }

    @Override
    public void massClienteInsert(Integer quantidade) {
        logger.info("Iniciando geração de clientes");
        for (int i =0; i<quantidade;i++)
        {
           Cliente c = ClienteUtil.gerarClienteAleatorio();
           saveCliente (c);
            logger.info("Cliente Gerado: "+ c.getNome());
        }
    }

    public void saveCliente(Cliente cliente)
    {
        logger.info("Salvando cliente");
        this.clienteRepository.save(cliente);
    }

}
