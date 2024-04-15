package br.com.bancodojorge.apirest.infrastructure.services;

import br.com.bancodojorge.apirest.domain.dto.AgenciaDTO;
import br.com.bancodojorge.apirest.infrastructure.repository.AgenciaRepository;
import br.com.bancodojorge.apirest.infrastructure.repository.ClienteRepository;
import br.com.bancodojorge.apirest.infrastructure.spring.assembler.Assembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgenciaServiceImpl implements AgenciaService {

    Logger logger = LoggerFactory.getLogger(AgenciaService.class);
    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private Assembler assembler;
    @Override
    public List<AgenciaDTO> listarAgencias() {
        logger.info("Listar Agencias");
        return assembler.from(agenciaRepository.findAll(),AgenciaDTO.class);
    }
}
