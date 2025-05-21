package com.exemplo.alunodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exemplo.alunodb.model.Aluno;
import com.exemplo.alunodb.repository.AlunoRepository;
import com.exemplo.alunodb.shared.AlunoDTO;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Aluno> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Aluno criar(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setNota(dto.getNota());
        return repository.save(aluno);
    }

    public Optional<Aluno> atualizar(String id, AlunoDTO dto) {
        return repository.findById(id).map(aluno -> {
            aluno.setNome(dto.getNome());
            aluno.setNota(dto.getNota());
            return repository.save(aluno);
        });
    }

    public boolean deletar(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
