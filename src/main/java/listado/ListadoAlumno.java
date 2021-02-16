package listado;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import servicios.InsercionDB;

public class ListadoAlumno extends HttpServlet {
	
	private InsercionDB insercionDB = new InsercionDB();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Alumno> listAlumnos = insercionDB.listAlumnos();
		req.setAttribute("listAlumnos", listAlumnos);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LsAlumno.jsp");
		dispatcher.forward(req,resp);
	}
}
