package br.com.bancodojorge.apirest.infrastructure.spring.assembler.converter;

import br.com.bancodojorge.apirest.domain.dto.AgenciaDTO;
import br.com.bancodojorge.apirest.domain.model.Agencia;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AgenciaParaAgenciaDTO implements Converter<Agencia, AgenciaDTO> {

    @Override
    public AgenciaDTO convert(Agencia a)
    {
        AgenciaDTO dto = new AgenciaDTO();
        dto.agenciaCodigo=a.getId();
        dto.agenciaEndereco=a.getEnderecoAgencia();
        dto.agenciaNome=a.getNomeAgencia();
        dto.agenciaUf=a.getUfAgencia();
        return dto;
    }
}
