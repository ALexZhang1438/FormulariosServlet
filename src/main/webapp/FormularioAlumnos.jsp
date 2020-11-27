<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de alumnos</title>
</head>
<body>
	<form action="/confirmarA" method="post">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" placeholder="Insertar nombre" name="nombre"></td>
			</tr>
			<tr>
				<td>Edad</td>
				<td><input type="number" placeholder="Insertar Edad" name="edad"></td>
			</tr>
			<tr>
				<td>Titulo</td>
				<td>
					<input type="number" placeholder="Insertar titulo" name=titulo>
				</td>
				<td>
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
