package com.fjtm.alumno.model;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @Table(name="alumnos") de esta forma le ponemos el nombre a la tabla en la base de datos
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellidos;
	private int edad;
	private String curso;
	private String clase;
	private int[] notas = new int[6];
	
	// Constructores
	public Alumno() {
	
	}
	
	
	public Alumno(Long id, String nombre, String apellidos, int edad, String curso, String clase,
			int[] notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.curso = curso;
		this.clase = clase;
		this.notas = notas;
	}

	// Getter y Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", curso=" + curso + ", clase=" + clase + ", notas=" + Arrays.toString(notas) + "]";
	}

	public String toJSON() {
		
		return "{\"nombre\":\"" + nombre + "\",\"apellidos\":\"" + apellidos + "\",\"edad\":" + edad
				+ ",\"curso\":\"" + curso + "\",\"clase\":\"" + clase + "\",\"notas\":" + Arrays.toString(notas) + "}";
	}
	
}
