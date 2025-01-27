package com.fjtm.alumno;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fjtm.alumno.model.Alumno;
import com.fjtm.alumno.repository.AlumnoRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // Usamos CommandLineRunner para ejecutar código después de iniciar la aplicación
    // en este caso iniciar el contenido de la base de datos
    // @Bean
    // public CommandLineRunner iniciarBD(AlumnoRepository repo) {
    //     return (args) -> {
    //         int notas[] = { 10, 10, 9, 10, 9, 10 };

    //         // Creación de los alumnos
    //         List<Alumno> alumnos = List.of(
    //             new Alumno(null, "Francisco José", "de la Torre Molina", 40, "segundo", "DAW", null),
    //             new Alumno(null, "fran2", "de la Torre Molina", 39, "segundo", "DAW", null),
    //             new Alumno(null, "fran3", "de la Torre Molina", 39, "segundo", "DAW", null),
    //             new Alumno(null, "fran4", "de la Torre Molina", 39, "segundo", "DAW", null),
    //             new Alumno(null, "fran5", "de la Torre Molina", 39, "segundo", "DAW", null),
    //             new Alumno(null, "fran6", "de la Torre Molina", 39, "segundo", "DAW", null)
    //         );

    //         // Guardamos los alumnos en la base de datos
    //         repo.saveAll(alumnos);

    //         // Puedes agregar más lógica si lo necesitas, por ejemplo, hacer algún log
    //         System.out.println("Alumnos insertados: " + alumnos.size());
    //     };
    // }
}

