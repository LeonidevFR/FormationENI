<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Accueil</title>
</head>
<body>
	<h1>Accueil</h1>
	<form action=ServletAccueil method="post">
		<input type="submit" name="ajouter" value="Ajouter un nouveau repas">
	</form>
	<br>
	<form action=ServletAccueil method="post">
		<input type="submit" name="afficher" value="Visualiser les repas">
	</form>
</body>
</html>