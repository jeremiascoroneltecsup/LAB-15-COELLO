package com.tecsup.controllers;

import com.tecsup.model.daos.AlumnoDao;
import com.tecsup.model.documents.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

    @Autowired
    private AlumnoDao dao;

    private static final Logger log = LoggerFactory.getLogger(AlumnoRestController.class);

    @GetMapping
    public Flux<Alumno> index() {
        Flux<Alumno> alumnos = dao.findAll()
                .map(alumno -> {
                    alumno.nombre().toUpperCase();
                    return alumno;
                })
                .doOnNext(alumno -> log.info(alumno.nombre()));

        return alumnos;
    }
}