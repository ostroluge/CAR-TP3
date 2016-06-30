<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contenu carnet</title>
</head>

<body>
<%@ page import="model.Carnet" %>

	<% Carnet carnet = (Carnet) request.getAttribute("carnet");
	for (int i=0; i<carnet.personnes.size(); i++) { 
		out.println(carnet.personnes.get(i).getNom());
	}
	%>
</body>
</html>