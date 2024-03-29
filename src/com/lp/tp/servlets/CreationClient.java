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
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

        String message;
        boolean success = false;

        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire n'est pas renseign�, alors on affiche un message
         * d'erreur, sinon on affiche un message de succ�s
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {

            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. Veuillez cliquez sur ce ";
            success = false;

        } else {

            message = "Client cr�� avec succ�s !";
            success = true;

        }
        /*
         * Cr�ation du bean Client et initialisation avec les donn�es r�cup�r�es
         */
        Client client = new Client();
        client.setNomClient( nom );
        client.setPrenomClient( prenom );
        client.setAdresseClient( adresse );
        client.setTelephoneClient( telephone );
        client.setEmailClient( email );

        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_SUCCESS, success );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
