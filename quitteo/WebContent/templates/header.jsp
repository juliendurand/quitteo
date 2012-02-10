<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Editer une quittance de loyer | quitteo.com</title>
	<link rel="stylesheet" type="text/css" media="all" href="styles/style.css" />
	<script type="text/javascript" src="javascript/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="javascript/jquery.ui.datepicker-fr.js"></script>
	
	<script type="text/javascript">                                         
	  $(document).ready(function() {
		  jQuery.datepicker.setDefaults(jQuery.datepicker.regional['fr']);
		  jQuery(".datepicker").mousedown(function(){
			  jQuery(".datepicker").datepicker('change', {dateFormat: 'dd MM yy', firstDay:1 }).attr("readonly","readonly");
	  	  });
		  $(".datepicker").datepicker();
		});                                 
 	</script>
</head>
<body>
	<header>
				<h1><a href="./" title="Quitteo" rel="home">Quitteo</a></h1>
				<h2>Pour editer facilement vos quittances de loyer</h2>
	</header>
	<nav>
		<ul>
			<li><a href="#">Accueil</a></li>
			<li><a href="#">Propri&eacute;taire</a></li>
			<li><a href="#">Locataire</a></li>
			<li><a href="#">Blog</a></li>
		</ul>		
	</nav>
	<div id="content">
		<div id="mainContent">
			<section>