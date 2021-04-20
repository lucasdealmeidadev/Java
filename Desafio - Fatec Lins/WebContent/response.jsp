<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Desafio - P1</title>
	</head>
	<body>
		<h1><% out.println("Olá, " + request.getAttribute("name")); %></h1>
	</body>
</html>