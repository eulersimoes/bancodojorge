package br.com.bancodojorge.apirest.domain.exception;

public class ClienteNotFoundException  extends RuntimeException {
    public ClienteNotFoundException(Long id) {
        super("Cliente não localizado, id: " + id);
    }
}