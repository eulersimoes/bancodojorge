package br.com.bancodojorge.apirest.domain.dto;

import java.io.Serializable;

public class AuthenticateResponseDto implements Serializable {

    private static final long serialVersionUID = -8091879045624046844l;
    private final String jwttoken;
    public AuthenticateResponseDto(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

}