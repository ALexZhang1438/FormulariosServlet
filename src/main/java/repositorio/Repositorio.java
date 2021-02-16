package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connection.ConnectionManager;
import connection.ConnectionH2;
import modelo.Alumno;
import modelo.Titulacion;

public class Repositorio {
	private static final String SQL_SEARCH_TITULO = "SELECT titulo FROM TITULACION;";
	private static final String SQL_SEARCH_ALUMNO = "SELECT * FROM ALUMNO;";
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/create.sql";
	ConnectionManager manager = new ConnectionH2();
	
	//buscar alumnos
	public Alumno search(Alumno alumnoFormulario) {
		Alumno alumnoInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE nombre = ?");
			prepareStatement.setString( 1, alumnoFormulario.getNombre());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				alumnoInDatabase = new Alumno();
				alumnoInDatabase.setNombre(resultSet.getString(1));
				alumnoInDatabase.setEdad(resultSet.getInt(2));
				alumnoInDatabase.setTitulacion(resultSet.getInt(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return alumnoInDatabase;
	}
	// buscar titulaciones
	public Titulacion search(Titulacion tituloFormulario) {
		Titulacion tituloInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM TITULACION WHERE titulo = ?");
			prepareStatement.setString(1, tituloFormulario.getTitulo());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				tituloInDatabase = new Titulacion();
				tituloInDatabase.setTitulo(resultSet.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return tituloInDatabase;
	}
	//cerrar conexiones
	private void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	//cerrar conexiones
	private void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	// insertar Alumnos
	public void insertarAlumno(Alumno alumnoFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALUMNO (nombre,edad,titulacion) VALUES (?, ?, ?)");
			preparedStatement.setString(1, alumnoFormulario.getNombre());
			preparedStatement.setInt(2, alumnoFormulario.getEdad());
			preparedStatement.setInt(3, alumnoFormulario.getTitulacion());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	// editar alumnos
	public void editaAlumno(Alumno alumnoFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALUMNO SET nombre = ?,edad = ?, titulacion = ? WHERE nombre = ?");
			preparedStatement.setString(1, alumnoFormulario.getNombre());
			preparedStatement.setInt(2,alumnoFormulario.getEdad());
			preparedStatement.setInt(3,alumnoFormulario.getTitulacion());
			preparedStatement.setString(4, alumnoFormulario.getNombre());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	// insertar TITULACION
		public void insertarTitulo(Titulacion tituloFormulario) {
			Connection conn = manager.open(jdbcUrl);
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement("INSERT INTO TITULACION (titulo) VALUES (?)");
				preparedStatement.setString(1, tituloFormulario.getTitulo());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(preparedStatement);
			}

			manager.close(conn);
		}
		// editar TITULACION
		public void editaTitulo(Titulacion tituloFormulario) {
			Connection conn = manager.open(jdbcUrl);
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn
						.prepareStatement("UPDATE TITULACION SET titulo = ? WHERE titulo = ?");
				preparedStatement.setString(1, tituloFormulario.getTitulo());

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(preparedStatement);
				manager.close(conn);
			}

		}
		// Lista de Titulaciones
		public List<Titulacion> searchAllTitulo() {
			List<Titulacion> listTitulo = new ArrayList<Titulacion>();
			Connection conn = manager.open(jdbcUrl);
			ResultSet resultSet = null;
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = conn.prepareStatement(SQL_SEARCH_TITULO);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Titulacion tit = new Titulacion();
					tit.setTitulo(resultSet.getString(1));
					listTitulo.add(tit);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(resultSet);
				close(prepareStatement);
				manager.close(conn);
			}

			return listTitulo;
		}
		// Lista de Alumnos
		public List<Alumno> searchAllAlumno() {
			List<Alumno> listAlumnos = new ArrayList<Alumno>();
			Connection conn = manager.open(jdbcUrl);
			ResultSet resultSet = null;
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = conn.prepareStatement(SQL_SEARCH_ALUMNO);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Alumno alu = new Alumno();
					alu.setNombre(resultSet.getString(1));
					alu.setEdad(resultSet.getInt(2));
					alu.setTitulacion(resultSet.getInt(3));
					listAlumnos.add(alu);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(resultSet);
				close(prepareStatement);
				manager.close(conn);
			}

			return listAlumnos;
		}
}
