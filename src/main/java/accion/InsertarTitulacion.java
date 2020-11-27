package accion;
import javax.servlet.http.HttpServletRequest;
import modelo.Titulacion;

public class InsertarTitulacion {
	public static Titulacion assembleTituloFrom(HttpServletRequest req) {
		Titulacion titulacion = new Titulacion();
		String titulo = req.getParameter("titulo");
		titulacion.setTitulo(titulo);
		return titulacion;
	}
}
