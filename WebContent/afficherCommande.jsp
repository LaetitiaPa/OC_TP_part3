<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'une commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    <jsp:useBean id="client" class="com.lp.tp.beans.Client" scope="request" />
    <jsp:useBean id="commande" class="com.lp.tp.beans.Commande" scope="request" />

		<c:choose> 
			<c:when test= "${ success }">
				<p class = "succes"><c:out value = "${ message }"></c:out></p>
				<p>Client</p>
        		<%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande --%>
		        <p>Nom: <c:out value = "${ commande.client.nomClient }" /></p>
		        <p>Prénom: <c:out value = "${ commande.client.prenomClient }" /></p>
		        <p>Adresse: <c:out value = "${ commande.client.adresseClient }" /></p>
		   		<p>Numéro de téléphone: <c:out value = "${ commande.client.telephoneClient }" /></p>
		      	<p>Email: <c:out value = "${ commande.client.emailClient }" /></p>
		        <p>Commande</p>
		        <p>Date: <c:out value = "${ commande.date }" /></p>
		        <p>Montant: <c:out value = "${ commande.montant }" /></p>
		     	<p>Mode de paiement: <c:out value = "${ commande.modePaiement }" /></p>
		     	<p>Statut du paiement: <c:out value = "${ commande.statutPaiement }" /></p>
		     	<p>Mode de livraison: <c:out value = "${ commande.modeLivraison }" /></p>
		   		<p>Statut de la livraison: <c:out value = "${ commande.statutLivraison }" /></p>
			</c:when>
			
			<c:otherwise>
				<p class = "info"><c:out value = "${ message }" /><a href = "<c:url value="creerCommande.jsp"/>">lien</a> pour accéder au formulaire de création d'une commande </p> 
			</c:otherwise>
		</c:choose>
    </body>
</html>