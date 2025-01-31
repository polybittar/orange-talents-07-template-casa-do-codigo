package br.com.zupacademy.polyana.casadocodigo.repository;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findById(Long id);
}
