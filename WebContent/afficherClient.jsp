<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<jsp:useBean id="client" class="com.lp.tp.beans.Client" scope="request" />
	<c:import url="inc/menu.jsp"/>
  	<%-- Affichage de la cha�ne "message" transmise par la servlet --%>
  	<c:choose>
  	
  		<c:when test= "${success}">
  			<p class= "succes"><c:out value = "${ message }"/></p>
  			<p>Nom: <c:out value = "${ client.nomClient }" /></p>
			<p>Pr�nom: <c:out value = "${ client.prenomClient }" /></p>
			<p>Adresse de livraison: <c:out value = "${ client.adresseClient }" /></p>
			<p>Num�ro de t�l�phone: <c:out value = "${ client.telephoneClient }" /></p>
			<p>Email: <c:out value = "${ client.emailClient }" /></p> 
  		</c:when>
			<c:otherwise>
			<p class = "info"><c:out value = "${ message }" /><a href = "<c:url value="creerClient.jsp"/>">lien</a> pour acc�der au formulaire de cr�ation d'un client </p> 
			</c:otherwise>
  	</c:choose>
  	
 </body>
</html>