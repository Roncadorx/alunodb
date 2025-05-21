package com.exemplo.alunodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// @Document: Indica que esta classe será uma coleção no MongoDB
@Document(collection = "alunos")
public class Aluno {

    // @Id: Identificador único no MongoDB
    @Id
    private String id;

    // @NotBlank: campo obrigatório (não pode ser vazio ou nulo)
    // @Size: define o tamanho mínimo e máximo permitido para o nome
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    // @Min/@Max: define o intervalo válido para a nota
    @Min(value = 0, message = "A nota mínima é 0")
    @Max(value = 10, message = "A nota máxima é 10")
    private double nota;

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
}
