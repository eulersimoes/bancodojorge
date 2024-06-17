/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bancodojorge.apirest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Euler
 */
@Entity(name = "conta")
@Table(name = "conta")
@Getter //lombok gerar automaticamente getters e setters da classe
@Setter //lombok gerar automaticamente getters e setters da classe
@AllArgsConstructor //lombok gerar automaticamente construtor recebendo todos parametros da classe
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @SequenceGenerator(name = "conta_sequence", sequenceName = "conta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_sequence")
    @Column(name = "CONT_CD_CONTA", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CONT_CD_AGENCIA")
    private Agencia agencia;

    @ManyToOne
    @JoinColumn(name = "CONT_CD_CLIENTE")
    private Cliente cliente;

    @Column(name = "cont_dt_criacao", nullable = false)
    private Date datacriacao;
    
    @OneToMany(mappedBy="conta")
    private List<MovimentacaoConta> movimentacoes;

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
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the datacriacao
     */
    public Date getDatacriacao() {
        return datacriacao;
    }

    /**
     * @param datacriacao the datacriacao to set
     */
    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    /**
     * @return the movimentacoes
     */
    public List<MovimentacaoConta> getMovimentacoes() {
        return movimentacoes;
    }

    /**
     * @param movimentacoes the movimentacoes to set
     */
    public void setMovimentacoes(List<MovimentacaoConta> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

}
