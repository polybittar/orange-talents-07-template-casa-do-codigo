package br.com.zupacademy.polyana.casadocodigo.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private Double preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull @Future
    private LocalDate dataPublicacao;
    @ManyToOne @NotNull @Valid
    private Categoria categoria;
    @ManyToOne @NotNull @Valid
    private Autor autor;

    @Deprecated
    public Livro() {

    }

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn,
                 LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
