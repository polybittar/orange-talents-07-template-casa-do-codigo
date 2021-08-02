package br.com.zupacademy.polyana.casadocodigo.dto;
import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import br.com.zupacademy.polyana.casadocodigo.domain.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class DetalhesLivroResponse {

    private String tituloLivro;
    private String resumoLivro;
    private String sumarioLivro;
    private Double precoLivro;
    private Integer numeroPaginasLivro;
    private String isbnLivro;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacaoLivro;
    private DetalhesAutorResponse autor;

    public DetalhesLivroResponse(Livro livro) {

        autor = new DetalhesAutorResponse(livro.getAutor());
        tituloLivro = livro.getTitulo();
        resumoLivro = livro.getResumo();
        sumarioLivro = livro.getSumario();
        precoLivro = livro.getPreco();
        numeroPaginasLivro = livro.getNumeroPaginas();
        isbnLivro = livro.getIsbn();
        dataPublicacaoLivro = livro.getDataPublicacao();
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getResumoLivro() {
        return resumoLivro;
    }

    public String getSumarioLivro() {
        return sumarioLivro;
    }

    public Double getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumeroPaginasLivro() {
        return numeroPaginasLivro;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public LocalDate getDataPublicacaoLivro() {
        return dataPublicacaoLivro;
    }

    public DetalhesAutorResponse getAutor() {
        return autor;
    }
}
