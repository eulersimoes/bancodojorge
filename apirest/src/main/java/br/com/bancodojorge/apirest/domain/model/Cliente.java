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
import lombok.Setter;
  
@Entity(name="cliente")
@Table(name="cliente")
@Getter //lombok gerar automaticamente getters e setters da classe
@Setter //lombok gerar automaticamente getters e setters da classe
@AllArgsConstructor //lombok gerar automaticamente construtor recebendo todos parametros da classe
@EqualsAndHashCode(of="id")


public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="'sq_cliente'")
    @Column(name="codigo",nullable = false)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @Column(name = "telefone", nullable = true)
    private String telefone;
    
    @Column(name = "cpf", nullable = true)
    private String cpf;

}
