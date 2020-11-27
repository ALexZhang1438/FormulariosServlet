package confirmacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import servicios.InsercionDB;
	
public class ConfirmarAlumno extends HttpServlet {
		
		private InsercionDB insercionDB = new InsercionDB();
		
		public InsercionDB getInsercionDB() {
			return insercionDB;
		}

		public void setInsercionDB(InsercionDB insercionDB) {
			this.insercionDB = insercionDB;
		}
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Alumno alumno = insercionDB.assembleAlumnoFromRequest(req);
			System.out.println("alumno:"+ alumno);
			insercionDB.insertarOeditarAlumno(alumno);
			redirect(req,resp);
		}

		protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarAlumnoInsertado.jsp");
			dispatcher.forward(req,resp);
		}
}
