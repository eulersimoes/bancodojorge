package br.com.bancodojorge.apirest.domain.dto;

import java.io.Serializable;

public class AuthenticationRequestDto implements Serializable {

    private static final long serialVersionUID = 475468583005150743L;

    private String username;
    private String password;

    //need default constructor for JSON Parsing
    public AuthenticationRequestDto() {

    }

    public AuthenticationRequestDto(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}