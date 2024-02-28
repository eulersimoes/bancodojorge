package br.com.bancodojorge.apirest.domain.exception;

import br.com.bancodojorge.apirest.controllers.ClienteController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteNotFoundException  extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(ClienteNotFoundException.class);
    public ClienteNotFoundException(Long  id) {
        super("Cliente não localizado, id: " + id);
        logger.info("Cliente não localizado, id:" + id);
    }
}