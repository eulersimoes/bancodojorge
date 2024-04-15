package br.com.bancodojorge.apirest.infrastructure.services;

import br.com.bancodojorge.apirest.domain.dto.AgenciaDTO;
import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;

import java.util.List;

public interface AgenciaService {

     List<AgenciaDTO> listarAgencias();
}
