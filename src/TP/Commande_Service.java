package TP;

import TP.Commande;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Commande_Service {
    public static List<Commande> listeCommandes = new ArrayList<>();

    @WebMethod(operationName = "Ajouter_Commande")
    public String AjouterCommande(@WebParam(name = "commande") Commande c) {
        listeCommandes.add(c);
        return "Commande ajoutée avec succès";
    }

    @WebMethod(operationName = "Afficher_Commande")
    public Commande afficherCommande(@WebParam(name = "idcommande") int id) {
        for (Commande c : listeCommandes) {
            if (c.getID() == id) {
                return c;
            }
        }
        return null;
    }

    @WebMethod(operationName = "Liste_Commandes")
    public List<Commande> listerCommandes() {
        return listeCommandes;
    }
}