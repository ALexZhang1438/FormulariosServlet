package confirmacion;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.InsercionDB;
import modelo.Titulacion;



public class ConfirmarTitulacion extends HttpServlet {
	
	private InsercionDB insercionDB = new InsercionDB();
	
	public InsercionDB getInsercionDB() {
		return insercionDB;
	}

	public void setInsercionDB(InsercionDB insercionDB) {
		this.insercionDB = insercionDB;
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Titulacion titulo = insercionDB.assembleTituloFromRequest(req);
		System.out.println("titulo:"+ titulo);
		insercionDB.insertarOeditarTitulo(titulo);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MostrarTituloInsertado.jsp");
		dispatcher.forward(req,resp);
	}
	
}
