package com.lp.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.tp.beans.Client;

@WebServlet( "/CreationClient" )
public class CreationClient extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    /* Constantes */
    public static final String CHAMP_NOM        = "nomClient";
    public static final String CHAMP_PRENOM     = "prenomClient";
    public static final String CHAMP_ADRESSE    = "adresseClient";
    public static final String CHAMP_TELEPHONE  = "telephoneClient";
    public static final String CHAMP_EMAIL      = "emailClient";

    public static final String ATT_CLIENT       = "client";
    public static final String ATT_MESSAGE      = "message";
    public static final String ATT_SUCCESS      = "success";

    public static final String VUE              = "/afficherClient.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

        String message;
        boolean success = false;

        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {

            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. Veuillez cliquez sur ce ";
            success = false;

        } else {

            message = "Client créé avec succès !";
            success = true;

        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Client client = new Client();
        client.setNomClient( nom );
        client.setPrenomClient( prenom );
        client.setAdresseClient( adresse );
        client.setTelephoneClient( telephone );
        client.setEmailClient( email );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_SUCCESS, success );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
