package servicios;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import modelo.Titulacion;
import modelo.Alumno;
import accion.InsertarAlumno;
import accion.InsertarTitulacion;
import repositorio.Repositorio;


public class InsercionDB {
	
	private Repositorio repositorio = new Repositorio();
	
	public Alumno assembleAlumnoFromRequest(HttpServletRequest req) {
		return InsertarAlumno.assembleAlumnoFrom(req);
	}
	public void insertarOeditarAlumno(Alumno alumnoFormulario) {
		Alumno alumnoInDatabase = repositorio.search(alumnoFormulario);
		if(null == alumnoInDatabase){
			repositorio.insertarAlumno(alumnoFormulario);
		}else{
			repositorio.editaAlumno(alumnoFormulario);
		}
	}
	
	public Titulacion assembleTituloFromRequest(HttpServletRequest req) {
		return InsertarTitulacion.assembleTituloFrom(req);
	}
	
	public void insertarOeditarTitulo(Titulacion tituloFormulario) {
		Titulacion tituloInDatabase = repositorio.search(tituloFormulario);
		if(null == tituloInDatabase){
			repositorio.insertarTitulo(tituloFormulario);
		}else{
			repositorio.editaTitulo(tituloFormulario);
		}
	}
	
	public List<Alumno> listAlumnos() {
		return repositorio.searchAllAlumno();
	}
	
	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

}
