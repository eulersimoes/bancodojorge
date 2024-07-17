package br.com.bancodojorge.apirest.domain.model;

import jakarta.persistence.*;

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {

    @Id
    @SequenceGenerator(name="usuario_sequence",sequenceName="usuario_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_sequence")
    @Column(name="USUA_ID_USUARIO",nullable = false)
    private Long id;

    @Column(name="USUA_NM_USUARIO",nullable = false)
    private String username;

    @Column(name="USUA_DS_PASSWORD",nullable = false)
    private String password;

    @Column(name="USUA_NM_ROLE",nullable = false)
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIE_CD_CLIENTE", referencedColumnName = "CLIE_CD_CLIENTE")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
