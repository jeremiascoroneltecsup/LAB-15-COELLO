package com.tecsup;

import com.tecsup.model.documents.Alumno;
import com.tecsup.model.documents.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class S11DevEjemplo02Application implements CommandLineRunner {

	@Autowired
	private ReactiveMongoTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(S11DevEjemplo02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Borrar la colección de cursos
		template.dropCollection("cursos").subscribe();

		// Insertar cursos
		template.insert(new Curso("C01", "Java 17", 4)).subscribe();
		template.insert(new Curso("C02", "SPRING BOOT", 5)).subscribe();
		template.insert(new Curso("C03", "Jenkins", 3)).subscribe();
		template.insert(new Curso("C04", "kubernetes", 4)).subscribe();
		template.insert(new Curso("C05", "kafka", 3)).subscribe();
		template.insert(new Curso("C06", "microservicios", 4)).subscribe();
		template.insert(new Curso("C07", "angular", 5)).subscribe();
		template.insert(new Curso("C08", "typescript", 4)).subscribe();
		template.insert(new Curso("C09", "html", 4)).subscribe();
		template.insert(new Curso("C10", "css 3", 1)).subscribe();


		template.dropCollection("alumnos").subscribe();


		template.insert(new Alumno("A01", "Juan", "Perez", 22)).subscribe();
		template.insert(new Alumno("A02", "Maria", "Gomez", 24)).subscribe();
		template.insert(new Alumno("A03", "Pedro", "Lopez", 20)).subscribe();
		template.insert(new Alumno("A04", "Ana", "Martinez", 21)).subscribe();
		template.insert(new Alumno("A05", "Luis", "Rodriguez", 23)).subscribe();
	}
}