<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
</head>
<body>
<h1>Ceci est la page de résultat</h1>
<%
	int status = (int) request.getAttribute("status");
	int computer = (int) request.getAttribute("computer");
	String computerPick = "";
	String userPick = "";
	
	if(computer==1) {
		computerPick = "Pierre";
	} else if(computer==2) {
		computerPick = "Feuille";
	} else if (computer==3) {
		computerPick = "Ciseaux";
	}
	
	if(status==1) {
		userPick = "Pierre";
	} else if(computer==2) {
		userPick = "Feuille";
	} else if (computer==3) {
		userPick = "Ciseaux";
	}

	
	if (status==1) {
		out.println("Égalité.");
		out.println("<br>");
		out.print("Vous avez fait : " + userPick);
		out.println("<br>");
		out.print("Votre adversaire a fait : " + computerPick);
	} else if (status==2) {
		out.println("Vous avez gagné !");
		out.println("<br>");
		out.print("Vous avez fait : " + userPick);
		out.println("<br>");
		out.print("Votre adversaire a fait : " + computerPick);
	} else if(status==3) {
		out.println("Vous avez perdu...");
		out.println("<br>");
		out.print("Vous avez fait : " + userPick);
		out.println("<br>");
		out.print("Votre adversaire a fait : " + computerPick);
	}
%>
</body>
</html>