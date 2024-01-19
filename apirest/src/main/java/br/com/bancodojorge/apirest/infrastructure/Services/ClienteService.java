package br.com.bancodojorge.apirest.infrastructure.services;

import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.domain.model.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente findClienteById(Long id) throws Exception;
    public Cliente findClienteByCpf(String cpf) throws Exception;
    public List<ClienteDTO> listarClientes();


}
