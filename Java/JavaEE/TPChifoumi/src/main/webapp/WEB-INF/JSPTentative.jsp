<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Tentative</title>
</head>
<body>
	<h1>Bienvenue dans le jeu du CHI-FOU-MI</h1>
	<p>Veuillez choisir soit pierre, soit papier, soit ciseaux</p>
    <form action=ServletChifoumi method="post">
      <div id="flexbox">
  	<div>
      <img src="images/chi.png">
      <br>
		<input type="submit" name="subchi" id="submit" value="chi">
    </div>
    <div>
      <img src="images/fou.png">
            <br>
		<input type="submit" name="subfou" id="submit" value="fou">
    </div>
    <div>
      <img src="images/mi.png">
            <br>
		<input type="submit" name="submi" id="submit" value="mi">
    </div>
      </div>
  </form>
</body>
</html>