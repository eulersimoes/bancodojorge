package br.com.bancodojorge.apirest.controllers;

import br.com.bancodojorge.apirest.domain.dto.AgenciaDTO;
import br.com.bancodojorge.apirest.domain.dto.ClienteDTO;
import br.com.bancodojorge.apirest.infrastructure.services.AgenciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/agencia")
@RestController()
public class AgenciaController {

    @Autowired
    AgenciaService agenciaService;
    Logger logger = LoggerFactory.getLogger(AgenciaController.class);
    @GetMapping("/listarAgencias")
    public List<AgenciaDTO> listarAgencias()
    {
        logger.info("listarAgencias");
        return agenciaService.listarAgencias();
    }
}
