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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Euler
 */
@Entity(name = "movimentacao_conta")
@Table(name = "movimentacao_conta")
@Getter //lombok gerar automaticamente getters e setters da classe
@Setter //lombok gerar automaticamente getters e setters da classe
@AllArgsConstructor //lombok gerar automaticamente construtor recebendo todos parametros da classe
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MovimentacaoConta {

    @Id
    @SequenceGenerator(name = "movimentacao_conta_sequence", sequenceName = "movimentacao_conta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimentacao_conta_sequence")
    @Column(name = "moco_cd_movimentacao", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "moco_cd_conta")
    private Conta conta;

    @Column(name = "moco_vl_movimentacao", nullable = false)
    private Double valor;

    @Column(name = "moco_tp_movimentacao", nullable = false)
    private String tipo;

    @Column(name = "moco_dt_movimentacao", nullable = false)
    private Date data;

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
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

}
