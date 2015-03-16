<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="fr.noixcoop.nuceus.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MetierVarietes metier = new MetierVarietes();
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nuceus 0.1</title>
	</head>
	<body>
		<h1>Liste des varietes de Noix</h1>
		<hr/>
		<%
			List<Variete> varietes = metier.consulter();
		%>
		<table border="1" style="border-collapse:collapse">
			<thead>
				<tr>
					<th>Libellé</th>
					<th>AOC</th>
				</tr>
			</thead>
			<tbody>
				<%
					String valeur = "";
					for(Variete variete : varietes){
						if(variete.isAoc()){
							valeur = "oui";
						}
						else{
							valeur = "non";
						}
					
						
				%>
				<tr>
					<td>
						<%= variete.getLibelle() %>
					</td>
					<td>
						<%= valeur %>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</body>
</html>