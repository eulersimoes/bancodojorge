package br.com.bancodojorge.apirest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name="cliente")
@Table(name="cliente")
@Getter //lombok gerar automaticamente getters e setters da classe
@Setter //lombok gerar automaticamente getters e setters da classe
@AllArgsConstructor //lombok gerar automaticamente construtor recebendo todos parametros da classe
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class Cliente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="'sq_cliente'")
    @Column(name="clie_cd_cliente",nullable = false)
    private Long id;
    
    @Column(name = "clie_nm_cliente", nullable = false)
    private String nome;
    
    @Column(name = "clie_ds_endereco", nullable = false)
    private String endereco;
    
    @Column(name = "clie_dt_nascimento", nullable = true)
    private Date dataNascimento;

    @Column(name = "clie_cd_cpf", nullable = false)
    private String cpf;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
