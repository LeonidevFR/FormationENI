<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Ajout repas</title>
</head>
<body>
	<h1>Ajout d'un repas</h1>
	<br>
	<p>Ajouter un nouveau repas : </p>
	<form action=ServletAjouterRepas method="post">
		<label for="date">Date :</label>
		<input type="text" name="date" placeholder="jj/mm/yyyy">
		<br>
		<label for="date">Heure :</label>
		<input type="text" name="time" placeholder="hh:mm(:ss)">
		<br>
		<label for="date">Ingrédients / Plat(s) :</label>
		<input type="text" name="meal" placeholder="Ingrédients ou plat">
		<br>
		<input type="submit" name="submit" value ="Valider">
		<input type="submit" name="cancel" value="Annuler">
	</form>
</body>
</html>