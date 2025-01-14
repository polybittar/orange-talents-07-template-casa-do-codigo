package br.com.zupacademy.polyana.casadocodigo.repository;

import br.com.zupacademy.polyana.casadocodigo.domain.Cliente;
import br.com.zupacademy.polyana.casadocodigo.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
