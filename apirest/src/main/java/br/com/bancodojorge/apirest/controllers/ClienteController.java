/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancodojorge.apirest.controllers;

import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.domain.model.Cliente;
import br.com.bancodojorge.apirest.infrastructure.services.ClienteService;
import br.com.bancodojorge.apirest.infrastructure.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Euler
 */
@RequestMapping("/cliente")
@RestController()
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/teste")
    public String teste()
    {
        return "teste";
    }
    
    @GetMapping("/getCliente/{id}")
    public Cliente getClientebyId(@PathVariable Long id) throws Exception
    {
        return clienteService.findClienteById(id);
    }
    

    @GetMapping("/listarClientes")
    public List<ClienteDTO> listarCliente()
    {
        return clienteService.listarClientes();
    }

    @GetMapping("/gerarClientes/{quant}")
    public void GerarClientes(@PathVariable Integer quant) throws Exception
    {
            clienteService.massClienteInsert(quant);
    }
    
}
