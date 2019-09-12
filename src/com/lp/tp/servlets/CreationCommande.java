package com.lp.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.lp.tp.beans.Client;
import com.lp.tp.beans.Commande;

@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {

    private static final long  serialVersionUID       = 1L;

    /* Constantes */
    public static final String CHAMP_NOM              = "nomClient";
    public static final String CHAMP_PRENOM           = "prenomClient";
    public static final String CHAMP_ADRESSE          = "adresseClient";
    public static final String CHAMP_TELEPHONE        = "telephoneClient";
    public static final String CHAMP_EMAIL            = "emailClient";

    public static final String CHAMP_DATE             = "dateCommande";
    public static final String CHAMP_MONTANT          = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";

    public static final String ATT_COMMANDE           = "commande";
    public static final String ATT_MESSAGE            = "message";
    public static final String ATT_ERREUR             = "erreur";

    public static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";

    public static final String VUE                    = "/afficherCommande.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

        /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format choisi */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        String date = dt.toString( formatter );
        double montant;
        try {
            /* Récupération du montant */
            montant = Double.parseDouble( request.getParameter( CHAMP_MONTANT ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation à -1 si le montant n'est pas un nombre correct */
            montant = -1;
        }
        String modePaiement = request.getParameter( CHAMP_MODE_PAIEMENT );
        String statutPaiement = request.getParameter( CHAMP_STATUT_PAIEMENT );
        String modeLivraison = request.getParameter( CHAMP_MODE_LIVRAISON );
        String statutLivraison = request.getParameter( CHAMP_STATUT_LIVRAISON );

        String message;
        boolean success = false;

        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */

        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || montant == -1
                || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. Veuillez cliquer sur ce ";
            success = false;

        } else {
            message = "Commande créée avec succès !";
            success = true;

        }
        /*
         * Création des beans Client et Commande et initialisation avec les
         * données récupérées
         */
        Client client = new Client();
        client.setNomClient( nom );
        client.setPrenomClient( prenom );
        client.setAdresseClient( adresse );
        client.setTelephoneClient( telephone );
        client.setEmailClient( email );

        Commande commande = new Commande();
        commande.setClient( client );
        commande.setDate( date );
        commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutPaiement( statutPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatutLivraison( statutLivraison );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "commande", commande );
        request.setAttribute( "message", message );
        request.setAttribute( "success", success );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
