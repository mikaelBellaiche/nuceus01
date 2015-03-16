<%@ page import="java.util.*" %>
<%@ page import="fr.noixcoop.nuceus.*" %>

<!DOCTYPE html>
<html lang="fr">
<link href="style/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet"/>
<%
	MetierVarietes metier = new MetierVarietes();
%>
	<head>
		<meta charset="utf8"/>
	</head>
	<body>
		<center><h1><u>Liste des varietes de Noix</u></h1></center>
		<hr/>
		<%
			List<Variete> varietes = metier.consulter();
		%>
		<table class="table table-hover table-bordered">
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