<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alumno Insertado</title>
</head>
	<body>
		<b><%= request.getParameter("nombre") %></b>
		<b><%= request.getParameter("edad") %></b>
		<b><%= request.getParameter("titulo") %></b>
		<br>
		<a href="index.jsp">Index</a>
		<br>
		<a>Listado Alumnos</a>
	</body>
</html>