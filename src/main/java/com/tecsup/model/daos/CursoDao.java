package com.tecsup.model.daos;

import com.tecsup.model.documents.Curso;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CursoDao extends ReactiveMongoRepository<Curso, String> {
}