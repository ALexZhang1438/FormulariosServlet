<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,modelo.Modelo" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/listadoA" method="post">
	<input type="submit" value="ver listado">
</form>

<%
	List<Modelo> alumno = (List<Modelo>)request.getAttribute("listAlumnos");
 out.println(alumno);
 pageContext.setAttribute("alumno", alumno);
%>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<table border="1">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>edad</td>
			<td>titulo</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="alumno" items="${listAlumnos}">
			<tr>
				<td><c:out value="${alumno.nombre}"/> </td>
				<td><c:out value="${alumno.edad}"/> </td>
				<td><c:out value="${alumno.titulo}"/> </td>
				<!--  <td><a href="/edit?id=${alumno.userName}">EDITAR</a> </td>-->
				
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</body>
</html>