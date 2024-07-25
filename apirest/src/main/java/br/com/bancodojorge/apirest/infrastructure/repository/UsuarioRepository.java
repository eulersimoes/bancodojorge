package br.com.bancodojorge.apirest.infrastructure.repository;

import br.com.bancodojorge.apirest.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from usuario u where u.username =:username")
    Optional<Usuario> findByUsername(String username);
}