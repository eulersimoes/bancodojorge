package br.com.bancodojorge.apirest.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="agencia")
@Table(name="agencia")
@Getter //lombok gerar automaticamente getters e setters da classe
@Setter //lombok gerar automaticamente getters e setters da classe
@AllArgsConstructor //lombok gerar automaticamente construtor recebendo todos parametros da classe
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Agencia {

    @Id
    @SequenceGenerator(name="agencia_sequence",sequenceName="agencia_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agencia_sequence")
    @Column(name="AGEN_CD_AGENCIA",nullable = false)
    private Long id;

    @Column(name = "AGEN_NM_AGENCIA", nullable = false)
    private String nomeAgencia;

    @Column(name = "AGEN_DS_ENDERECO", nullable = false)
    private String enderecoAgencia;

    @Column(name = "AGEN_UF_AGENCIA", nullable = false)
    private String ufAgencia;



}
