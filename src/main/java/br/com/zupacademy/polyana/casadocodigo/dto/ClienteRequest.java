package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Cliente;
import br.com.zupacademy.polyana.casadocodigo.domain.Estado;
import br.com.zupacademy.polyana.casadocodigo.domain.Pais;
import br.com.zupacademy.polyana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.polyana.casadocodigo.validator.DocumentValidator;
import br.com.zupacademy.polyana.casadocodigo.validator.ExistsId;
import br.com.zupacademy.polyana.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank @Email @UniqueValue(fieldName = "email", domainClass = Cliente.class)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @DocumentValidator @UniqueValue(fieldName = "documento", domainClass = Cliente.class)
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotNull @ExistsId(fieldName = "id", domainClass = Pais.class)
    private Long paisId;
    private Long idEstado;

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Long paisId, Long idEstado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.paisId = paisId;
        this.idEstado = idEstado;
    }

    public Cliente converter(PaisRepository paisRepository,EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(paisId);
        Optional<Estado> estado = null;
        if (idEstado != null) {
            estado = estadoRepository.findById(idEstado);
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais.get(), estado.get());

        } else {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais.get());
        }
    }


    public Long getPaisId() {
        return paisId;
    }

    public Long getIdEstado() {
        return idEstado;
    }

}
