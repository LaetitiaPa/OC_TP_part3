<%@ page pageEncoding="UTF-8" %>
<c:import url="inc/menu.jsp"/>
<c:import url="inc/inc_client_form.jsp"/>

	<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<div>
      		<form method="get" action="creationCommande">
      			<c:import url="inc/inc_client_form.jsp"/>
		
		 	</form>
			<input type="submit" value="Valider"  />
		    <input type="reset" value="Remettre à zéro" /> <br />
		</div>	
    </body>

</html>