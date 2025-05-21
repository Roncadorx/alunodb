package com.exemplo.alunodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.exemplo.alunodb.model.Aluno;

// Interface que comunica com o banco de dados MongoDB
// MongoRepository<Aluno, String>: define que o repositório trabalha com a entidade Aluno e o ID é do tipo String
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
