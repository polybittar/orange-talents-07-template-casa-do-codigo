package br.com.zupacademy.polyana.casadocodigo.repository;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import br.com.zupacademy.polyana.casadocodigo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findById(Long id);
}
