package br.com.bancodojorge.apirest.controllers;

import br.com.bancodojorge.apirest.domain.model.Cliente;
import br.com.bancodojorge.apirest.domain.model.Conta;
import br.com.bancodojorge.apirest.infrastructure.repository.ClienteRepository;
import br.com.bancodojorge.apirest.infrastructure.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @QueryMapping
    public List<Cliente> clienteListGraphiql() {
        return clienteRepository.findAll();
    }

    @QueryMapping
    public Long clienteCountGraphiql() {
        return clienteRepository.count();
    }

    @QueryMapping
    public Optional<Cliente> clienteByIdGraphiql(@Argument Long id) {
        return clienteRepository.findById(id);
    }

    @QueryMapping
    public List<Conta> contaListGraphiql() {
        return contaRepository.findAll();
    }

}
