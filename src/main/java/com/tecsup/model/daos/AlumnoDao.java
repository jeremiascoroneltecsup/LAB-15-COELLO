package com.tecsup.model.daos;

import com.tecsup.model.documents.Alumno;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AlumnoDao extends ReactiveMongoRepository<Alumno, String> {
}