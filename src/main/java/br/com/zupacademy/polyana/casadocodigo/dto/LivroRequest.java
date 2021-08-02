package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import br.com.zupacademy.polyana.casadocodigo.domain.Categoria;
import br.com.zupacademy.polyana.casadocodigo.domain.Livro;
import br.com.zupacademy.polyana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.polyana.casadocodigo.validator.ExistsId;
import br.com.zupacademy.polyana.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class LivroRequest {

    @NotBlank @UniqueValue(fieldName = "titulo", domainClass = Livro.class)
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private Double preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotBlank @UniqueValue(fieldName = "isbn",domainClass = Livro.class)
    private String isbn;
    @NotNull @Future
    private LocalDate dataPublicacao;
    @NotNull @ExistsId(domainClass = Categoria.class,fieldName="id")
    private Long idCategoria;
    @NotNull @ExistsId(domainClass = Autor.class,fieldName="id")
    private Long idAutor;

    public LivroRequest(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas,
                        String isbn,  LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById(this.idAutor);
        Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria.get(), autor.get());
    }
}
