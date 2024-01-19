package br.com.bancodojorge.apirest.infrastructure.spring.assembler.converter;

import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.domain.model.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class ClienteParaClienteDTO implements Converter<Cliente, ClienteDTO> {

    @Override
    public ClienteDTO convert(Cliente s)
    {
        ClienteDTO dto = new ClienteDTO();
        dto.cpf=s.getCpf();
        dto.nome=s.getNome();
        dto.endereco=s.getEndereco();
        dto.dataNascimento=s.getDataNascimento().toString();
        return dto;
    }
}
