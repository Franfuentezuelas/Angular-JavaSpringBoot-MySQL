package com.fjtm.alumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fjtm.alumno.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
