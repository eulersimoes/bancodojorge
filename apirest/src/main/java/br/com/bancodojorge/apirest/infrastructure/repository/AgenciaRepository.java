package br.com.bancodojorge.apirest.infrastructure.repository;


import br.com.bancodojorge.apirest.domain.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {


}
