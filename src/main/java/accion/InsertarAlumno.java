package accion;

import javax.servlet.http.HttpServletRequest;

import modelo.Alumno;

public class InsertarAlumno {
	public static Alumno assembleAlumnoFrom(HttpServletRequest req) {
		// cogemos los datos del formulario
		Alumno alumno = new Alumno();
		String nombre_String = req.getParameter("nombre");
		int edad_Int = Integer.parseInt(req.getParameter("edad"));
		int titulo_int = Integer.parseInt(req.getParameter("titulo"));
		
		// Añadimos los datos del formulario a alumno
		alumno.setNombre(nombre_String);
		alumno.setEdad(edad_Int);
		alumno.setTitulacion(titulo_int);
		
		// Devolvemos el objeto alumnos con los datos cargados
		return alumno;
	}
}
